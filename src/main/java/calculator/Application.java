package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.NumberSeparator;
import calculator.domain.SeparatorGenerator;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        SeparatorGenerator separatorGenerator = new SeparatorGenerator();
        NumberSeparator numberSplitter = new NumberSeparator(separatorGenerator);
        Calculator calculator = new Calculator(numberSplitter);

        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        CalculatorController controller = new CalculatorController(inputView, resultView, calculator);

        controller.runCalculator();
    }
}
