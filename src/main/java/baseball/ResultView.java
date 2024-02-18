package baseball;

import java.util.Scanner;

public class ResultView {
    private Scanner scanner;
    public ResultView(){
        this.scanner = new Scanner(System.in);
    }

    public String getUserResultInput(){
        String input;
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        input = scanner.nextLine();

        return input;
    }
}
