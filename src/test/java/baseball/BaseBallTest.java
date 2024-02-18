package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BaseBallTest {
    private final String anyInput = "123";
    private final BaseBall baseBall = new BaseBall();

    @Test
    @DisplayName("입력받은 숫자의 범위가 000~999 이다.")
    void inputFormat() {
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
        String actual = baseBall.generateAnswer();

        boolean isLengthValid = actual.length() == 3;
        boolean isInRange = actual.matches("\\d{3}") && Integer.parseInt(actual) >= 0 && Integer.parseInt(actual) < 1000;

        assertTrue(isLengthValid && isInRange, "정답으로 생성된 숫자의 범위는 000~999이다.");
    }
    @Test
    @DisplayName("입력받은 숫자가 낫싱인 상태를 판단할 수 있다.")
    void validateNothing(){
        String actual = baseBall.validateAnswer(anyInput, "789");

        assertEquals("낫싱", actual, "입력값 중 정답과 같은 숫자가 한개도 없으면 '낫싱'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 0스트라이크 1볼인 상태를 판단할 수 있다.")
    void validateOneBall(){
        String actual = baseBall.validateAnswer(anyInput, "781");

        assertEquals("0스트라이크 1볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 1개 있으면 '0스트라이크 1볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 0스트라이크 2볼인 상태를 판단할 수 있다.")
    void validateTwoBall(){
        String actual = baseBall.validateAnswer(anyInput, "391");

        assertEquals("0스트라이크 2볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 2개 있으면 '0스트라이크 2볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 0스트라이크 3볼인 상태를 판단할 수 있다.")
    void validateThreeBall(){
        String actual = baseBall.validateAnswer(anyInput, "312");

        assertEquals("0스트라이크 3볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 3개 있으면 '0스트라이크 3볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 1스트라이크 0볼인 상태를 판단할 수 있다.")
    void validateOneStrike(){
        String actual = baseBall.validateAnswer(anyInput, "178");

        assertEquals("1스트라이크 0볼", actual, "입력값 중 동일한 위치의 숫자가 1개 있으면 '1스트라이크 0볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 2스트라이크 0볼인 상태를 판단할 수 있다.")
    void validateTwoStrike(){
        String actual = baseBall.validateAnswer(anyInput, "128");

        assertEquals("2스트라이크 0볼", actual, "입력값 중 동일한 위치의 숫자가 2개 있으면 '2스트라이크 0볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 3스트라이크 0볼인 상태를 판단할 수 있다.")
    void validateThreeStrike(){
        String actual = baseBall.validateAnswer(anyInput, "123");

        assertEquals("3스트라이크 0볼", actual, "입력값 중 동일한 위치의 숫자가 3개 있으면 '3스트라이크 0볼'인 상태를 반환해야 한다.");
    }
}
