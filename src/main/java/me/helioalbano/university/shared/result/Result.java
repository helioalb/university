package me.helioalbano.university.shared.result;

public class Result<T> {
    private final T value;
    private final String error;
    private final boolean isSuccess;

    private Result(final T value, final String error, final boolean isSuccess) {
        this.value = value;
        this.error = error;
        this.isSuccess = isSuccess;
    }

    public static <T> Result<T> success(final T value) {
        return new Result<>(value, null, true);
    }

    public static <T> Result<T> failure(final String error) {
        return new Result<>(null, error, false);
    }

    public T getValue() {
        return value;
    }

    public String getError() {
        return error;
    }

    public boolean isSuccess() {
        return isSuccess;
    }
}
