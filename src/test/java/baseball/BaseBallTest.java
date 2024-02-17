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
}
