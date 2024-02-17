package baseball;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    public InputView(){
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput(){
        String input;
        do {
            System.out.print("숫자를 입력해 주세요 : ");
            input = scanner.nextLine();
        } while (!isValidateInput(input));

        return input;
    }

    public boolean isValidateInput(String input) {
       return input.matches("\\d{3}");
    }
}
