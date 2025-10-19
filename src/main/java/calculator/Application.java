package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.parser.NumberParser;
import calculator.domain.separator.StringSeparator;
import calculator.domain.separator.strategy.CustomPatternSeparator;
import calculator.domain.separator.strategy.DefaultSeparator;
import calculator.domain.separator.strategy.Separator;
import calculator.domain.validator.NumberRangeValidator;
import calculator.domain.validator.SeparatorValidator;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Separator> separators = List.of(new CustomPatternSeparator(),
                new DefaultSeparator()); // 구분자를 정하는 strategy 생성

        /***
         * 입력값에 대한 유효성 검사 로직 생성
         */
        SeparatorValidator separatorValidator = new SeparatorValidator();
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();

        /***
         * 입출력 View 생성
         */
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        /***
         * 각 객체에 대한 의존성 주입
         */
        StringSeparator stringSeparator = new StringSeparator(separators, separatorValidator);
        NumberParser numberParser = new NumberParser(numberRangeValidator, stringSeparator);
        Calculator calculator = new Calculator(numberParser);

        CalculatorController controller = new CalculatorController(inputView, resultView, calculator);

        controller.runCalculator(); // 덧셈 계산기 실행
    }
}
