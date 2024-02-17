package baseball;

public class Main {
    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        String answer = baseBall.generateAnswer();

        InputView input = new InputView();
        input.getUserInput();
    }
}
