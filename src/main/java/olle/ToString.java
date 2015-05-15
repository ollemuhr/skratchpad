package olle;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ToString<T> {

    @SuppressWarnings("unchecked")
    default String autoToString() {
        return getName() + "{" +
                props().map(p -> p.apply((T) this))
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")) +
                "}";
    }

    default String getName() {
        final String fullName = this.getClass().getName();
        final String name = (fullName.lastIndexOf('$') != fullName.indexOf('$')) ?
                fullName.substring(fullName.indexOf('$') + 1, fullName.lastIndexOf('$')) :
                fullName.substring(fullName.lastIndexOf('.') + 1, fullName.lastIndexOf('$'));
        return name;
    }

    Stream<Function<T, ?>> props();
}