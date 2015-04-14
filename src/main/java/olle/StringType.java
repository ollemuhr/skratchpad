package olle;


/**
 *
 */
public interface StringType extends CharSequence, SimpleType<String>, ComparableType<String> {

    @Override
    default int length() {
        return value().length();
    }

    @Override
    default char charAt(int index) {
        return value().charAt(index);
    }

    @Override
    default CharSequence subSequence(int start, int end) {
        return value().subSequence(start, end);
    }

    default String toUpperCase() {
        return value().toUpperCase();
    }

    default String toLowerCase() {
        return value().toLowerCase();
    }
}
