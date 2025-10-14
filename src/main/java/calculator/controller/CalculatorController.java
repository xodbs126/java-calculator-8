package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;
import java.io.IOException;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, ResultView resultView, Calculator calculator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculator = calculator;
    }

    public void runCalculator() throws IOException {
        String stringInputs = inputView.input();
        int result = calculator.add(stringInputs);
        resultView.printResult(result);
    }

}
