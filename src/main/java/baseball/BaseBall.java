package baseball;

import java.util.Random;

public class BaseBall {
    public BaseBall(){
        String answer = generateAnswer();
    }

    public String generateAnswer() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        return String.format("%03d", randomNumber);
    }

    public String validateAnswer(String anyInput, String anyAnswer) {
        String status = "";

        int strike = 0;
        int ball = 0;

        if(strike == 0 && ball == 0){
           status = "낫싱";
        }

        return status;
    }
}
