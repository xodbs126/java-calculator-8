package calculator.domain.validator;

/***
 * 사용자 입력에 대한 Validator 인터페이스 구현
 * @param <T>
 */
public interface Validator<T> {
    T isValid(T value);
}
