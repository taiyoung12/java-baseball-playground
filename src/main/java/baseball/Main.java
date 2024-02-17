package baseball;

public class Main {
    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        String answer = baseBall.generateAnswer();

        InputView input = new InputView();
        String userInput = input.getUserInput();

        String status = baseBall.validateAnswer(userInput, answer);
        System.out.println(status);
    }
}
