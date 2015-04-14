package olle;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

public interface EqualsHashcode<T> {

    @SuppressWarnings("unchecked")
    default boolean autoEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final T that = (T) o;
        return props().allMatch(prop ->
                equalsTester(prop.apply((T) this), prop.apply(that)));
    }

    @SuppressWarnings("unchecked")
    default int autoHashCode() {
        return Objects.hash(props()
                .map(prop -> hasher(prop.apply((T) this))).toArray());
    }

    default Object hasher(Object prop) {
        return prop;
    }

    default Boolean equalsTester(Object a, Object b) {
        return Objects.equals(a, b);
    }

    Stream<Function<T, ?>> props();
}