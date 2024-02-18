package baseball;

public class Main {
    public static void main(String[] args) {
        BaseBall baseBall = new BaseBall();
        String answer = baseBall.generateAnswer();
        System.out.println(answer);

        InputView input = new InputView();
        String status;

        do {
            String userInput = input.getUserInput();
            status = baseBall.validateAnswer(userInput, answer);
            System.out.println(status);
        } while (!"3스트라이크 0볼".equals(status));
    }
}
