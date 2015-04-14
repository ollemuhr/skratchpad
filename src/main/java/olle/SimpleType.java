package olle;

import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *
 */
public interface SimpleType<T> extends ToString, EqualsHashcode {

    T value();

    default Stream<ValidationError> validate() {
        return Stream.empty();
    }

    @Override
    default Stream<Function<SimpleType, T>> props() {
        return Stream.of(SimpleType<T>::value);
    }

    @SuppressWarnings("unchecked")
    static <M extends SimpleType<T>, T> M newMicroType(Class<M> clazz, T value) {
        try {
            return (M) clazz.getMethod("of", value.getClass()).invoke(null, value);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
