package baseball;

import java.util.Random;

public class BaseBall {
    private String answer;

    public BaseBall(){
       this.answer = generateAnswer();
    }

    public String generateAnswer() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        return String.format("%03d", randomNumber);
    }
}
