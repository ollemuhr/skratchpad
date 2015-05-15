package olle;

import static olle.Primitivies.*;

/**
 *
 */
public class ValidationError {
    private final String message;
    private final ErrorCode errorCode;

    public ValidationError(String message, ErrorCode errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public  String getMessage() {
        return message;
    }
    public ErrorCode getCode() {
        return errorCode;
    }

    @Override
    public String toString() {
        return "ValidationError{" +
                "message='" + message + '\'' +
                ", errorCode=" + errorCode +
                '}';
    }

    public interface ErrorCode extends IntegerType {
        abstract class EC extends Value<SimpleType<Integer>> implements ErrorCode {}
        static ErrorCode of(Integer value) {
            return new EC() {
                @Override
                public Integer value() {
                    return value;
                }
            };
        }
    }
}
