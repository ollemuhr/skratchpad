package olle;

/**
 *
 */
public abstract class Value<T> implements ToString<T>, EqualsHashcode<T> {

    @Override
    public boolean equals(Object obj) {
        return autoEquals(obj);
    }

    @Override
    public int hashCode() {
        return autoHashCode();
    }

    @Override
    public String toString() {
        return autoToString();
    }
}
