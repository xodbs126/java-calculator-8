package calculator.domain.validator;

public interface Validator<T> {
    T isValid(T value);
}
