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
import java.io.IOException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        List<Separator> separators = List.of(new CustomPatternSeparator(), new DefaultSeparator());

        SeparatorValidator separatorValidator = new SeparatorValidator();
        NumberRangeValidator numberRangeValidator = new NumberRangeValidator();
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        StringSeparator stringSeparator = new StringSeparator(separators, separatorValidator);
        NumberParser numberParser = new NumberParser(numberRangeValidator, stringSeparator);
        Calculator calculator = new Calculator(numberParser);

        CalculatorController controller = new CalculatorController(inputView, resultView, calculator);

        controller.runCalculator();
    }
}
