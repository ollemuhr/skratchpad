package olle;

import javax.xml.bind.DatatypeConverter;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 */
public interface Primitivies {


    interface IntegerType extends SimpleType<Integer> , ComparableType<Integer> {
    }

    interface ByteArrayType extends SimpleType<byte[]> {

        default String hexString() {
            return DatatypeConverter.printHexBinary(value());
        }

        @Override
        default Boolean equalsTester(Object a, Object b) {
            return Arrays.equals((byte[]) a, (byte[]) b);
        }

        @Override
        default Object hasher(Object prop) {
            return Arrays.hashCode((byte[]) prop);
        }
    }

    interface OptionalType<T> extends SimpleType<Optional<T>> {
    }
}
