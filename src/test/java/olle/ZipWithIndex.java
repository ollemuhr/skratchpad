package olle;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.junit.Assert.assertEquals;

public class ZipWithIndex {

    private static final List<Pair<String, String>> labels = Stream.of(Pair.of("l1a", "l1b"), Pair.of("l2a", "l2b"))
            .collect(Collectors.toList());

    private static final Map<Integer, String> expected = new HashMap<>();

    @BeforeClass
    public static void beforeClass() {
        expected.put(1, "l1a");
        expected.put(2, "l1b");
        expected.put(3, "EN");
        expected.put(4, "l2a");
        expected.put(5, "l2b");
        expected.put(6, "EN");
    }


    @Test
    public void _1() {

        final Query query = new Query();
        int i = 0;
        for (Pair<String, String> label : labels) {
            query.setParameter(++i, label._1());
            query.setParameter(++i, label._2());
            query.setParameter(++i, "EN");
        }

        assertEquals(expected, query.map);
    }

    @Test
    public void _2() {
        final Query query = new Query();
        final AtomicInteger i = new AtomicInteger(1);

        labels.stream().forEach(label -> {
            query.setParameter(i.getAndIncrement(), label._1());
            query.setParameter(i.getAndIncrement(), label._2());
            query.setParameter(i.getAndIncrement(), "EN");
        });

        assertEquals(expected, query.map);
    }

    @Test
    public void _3() {
        final int nrOfParams = 3;
        final Query query = new Query();

        IntStream.range(0, labels.size() * nrOfParams).filter(i -> i % nrOfParams == 0)
                .forEach(i -> {
                    query.setParameter(i + 1, labels.get(i / nrOfParams)._1());
                    query.setParameter(i + 2, labels.get(i / nrOfParams)._2());
                    query.setParameter(i + 3, "EN");
                });

        assertEquals(expected, query.map);

    }

    @Test
    public void _4() {
        final Query query = new Query();

        final Stream<String> values = labels.stream().flatMap(label -> Stream.of(label._1(), label._2(), "EN"));

        zipWithIndex(values)
                .forEach(pair -> {
                    query.setParameter(pair._1() + 1, pair._2());
                });

        assertEquals(expected, query.map);
    }

    @Test
    public void _5() {
        final Query query = new Query();
        final List<String> values = labels.stream().flatMap(label -> Stream.of(label._1(), label._2(), "EN")).collect(Collectors.toList());

        IntStream.range(0, values.size())
                .forEach(i -> {
                    query.setParameter(i +  1, values.get(i));
                });

        assertEquals(expected, query.map);
    }

    interface Pair<A, B> {

        static <A, B> Pair<A, B> of(final A a, final B b) {
            return new Pair<A, B>() {

                @Override
                public A _1() {
                    return a;
                }

                @Override
                public B _2() {
                    return b;
                }
            };
        }

        A _1();

        B _2();

    }

    class Query {
        private Map<Integer, String> map = new HashMap<>();

        void setParameter(int index, String value) {
            map.put(index, value);
        }
    }



    public static <A> Stream<Pair<Integer, A>> zipWithIndex(final Stream<? extends A> stream) {
        final List<A> list = stream.collect(Collectors.toList());

        return zip(IntStream.range(0, list.size()).boxed(), list.stream(), Pair::of);
    }

    /**
     * http://stackoverflow.com/a/23529010
     */
    public static <A, B, C> Stream<C> zip(Stream<? extends A> a,
                                          Stream<? extends B> b,
                                          BiFunction<? super A, ? super B, ? extends C> zipper) {
        Objects.requireNonNull(zipper);
        @SuppressWarnings("unchecked")
        Spliterator<A> aSpliterator = (Spliterator<A>) Objects.requireNonNull(a).spliterator();
        @SuppressWarnings("unchecked")
        Spliterator<B> bSpliterator = (Spliterator<B>) Objects.requireNonNull(b).spliterator();

        // Zipping looses DISTINCT and SORTED characteristics
        int both = aSpliterator.characteristics() & bSpliterator.characteristics() &
                ~(Spliterator.DISTINCT | Spliterator.SORTED);
        int characteristics = both;

        long zipSize = ((characteristics & Spliterator.SIZED) != 0)
                ? Math.min(aSpliterator.getExactSizeIfKnown(), bSpliterator.getExactSizeIfKnown())
                : -1;

        Iterator<A> aIterator = Spliterators.iterator(aSpliterator);
        Iterator<B> bIterator = Spliterators.iterator(bSpliterator);
        Iterator<C> cIterator = new Iterator<C>() {
            @Override
            public boolean hasNext() {
                return aIterator.hasNext() && bIterator.hasNext();
            }

            @Override
            public C next() {
                return zipper.apply(aIterator.next(), bIterator.next());
            }
        };

        Spliterator<C> split = Spliterators.spliterator(cIterator, zipSize, characteristics);
        return (a.isParallel() || b.isParallel())
                ? StreamSupport.stream(split, true)
                : StreamSupport.stream(split, false);
    }
}
