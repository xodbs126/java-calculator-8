package calculator.controller;

import calculator.domain.Calculator;
import calculator.view.InputView;
import calculator.view.ResultView;

public class CalculatorController {

    private final InputView inputView;
    private final ResultView resultView;
    private final Calculator calculator;

    public CalculatorController(InputView inputView, ResultView resultView, Calculator calculator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.calculator = calculator;
    }

    /***
     * InputView를 통해 사용자의 입력에 따른
     * Calculator 계산기 로직 실행
     * ResultView를 통한 결과값 반환
     */
    public void runCalculator() {
        String stringInputs = inputView.input();
        int result = calculator.add(stringInputs);
        resultView.printResult(result);
    }

}
