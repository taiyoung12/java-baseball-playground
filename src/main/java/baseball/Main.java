package baseball;

public class Main {
    public static void main(String[] args) {
        while (true) {
            BaseBall baseBall = new BaseBall();
            String answer = baseBall.generateAnswer();

            InputView input = new InputView();
            ResultView result = new ResultView();
            String status;

            do {
                String userInput = input.getUserInput();
                status = baseBall.validateAnswer(userInput, answer);
                System.out.println(status);
            } while (!"3스트라이크 0볼".equals(status));

            if(status.equals("3스트라이크 0볼")){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }

            String resultInput;

            do {
                resultInput = result.getUserResultInput();
                if ("1".equals(resultInput)) {
                    System.out.println("게임을 새로 시작합니다.");
                    break;
                }

                if("2".equals(resultInput)) {
                    System.out.println("게임을 종료합니다.");
                    return;
                }
            } while (!"1".equals(resultInput) && !"2".equals(resultInput));
        }
    }
}
