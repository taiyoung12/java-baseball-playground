package baseball;

import java.util.Random;

public class BaseBall {
    private final NumberValidate validator = new NumberValidate();
    public BaseBall(){
        String answer = generateAnswer();
    }
    public String generateAnswer() {
        Random random = new Random();
        String randomNumber;

        do {
            randomNumber = String.format("%03d", random.nextInt(1000));
        } while (!validator.validateNumber(randomNumber));

        return randomNumber;
    }
    public String validateAnswer(String input, String answer) {
        String status = "";

        int strike = 0;
        int ball = 0;

        for(int i = 0; i < input.length(); i++) {
            String currentInput = String.valueOf(input.charAt(i));
            String currentAnswer = String.valueOf(answer.charAt(i));

            if(!currentInput.equals(currentAnswer) && answer.contains(currentInput)){
                ball+=1;
            }

            if(currentInput.equals(currentAnswer)){
                strike+=1;
            }

        }

        if(strike == 0 && ball == 0){
           status = "낫싱";
        }

        if(!status.equals("낫싱")){
           status = strike + "스트라이크 " + ball + "볼";
        }

        return status;
    }
}
