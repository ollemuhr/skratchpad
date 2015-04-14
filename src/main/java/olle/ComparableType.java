package olle;

/**
 *
 */
public interface ComparableType <T extends Comparable<T>> extends SimpleType<T>, Comparable<ComparableType<T>> {

    @Override
    default int compareTo(ComparableType<T> o) {
        if (!o.getClass().equals(getClass())) {
            throw new RuntimeException("Cannot compare different types[" + getClass() + "] and [" + o.getClass() + "]");
        } else {
            return value().compareTo(o.value());
        }
    }
}
