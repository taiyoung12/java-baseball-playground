package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BaseBallTest {

    @Test
    @DisplayName("입력받은 숫자의 범위가 000~999 이다.")
    void inputFormat(){
        InputView inputView = new InputView();

        assertTrue(inputView.isValidateInput("000"));
        assertTrue(inputView.isValidateInput("999"));
        assertFalse(inputView.isValidateInput("0"));
        assertFalse(inputView.isValidateInput("1001"));
        assertFalse(inputView.isValidateInput("-1"));
        assertFalse(inputView.isValidateInput("abc"));
    }

    @Test
    @DisplayName("정답으로 생성된 숫자는 3자리 이며 범위는 000~999이다.")
    void generateAnswer() {
        BaseBall baseBall = new BaseBall();
        String actual = baseBall.generateAnswer();

        boolean isLengthValid = actual.length() == 3;
        boolean isInRange = actual.matches("\\d{3}") && Integer.parseInt(actual) >= 0 && Integer.parseInt(actual) < 1000;

        assertTrue(isLengthValid && isInRange, "정답으로 생성된 숫자의 범위는 000~999이다.");
    }
}
