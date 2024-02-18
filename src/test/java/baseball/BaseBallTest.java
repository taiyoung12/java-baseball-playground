package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BaseBallTest {
    private final String anyInput = "123";
    private final String answerNoting = "789";
    private final String answerOneBall = "451";
    private final String answerTwoBall = "431";
    private final String answerThreeBall = "312";
    private final String answerOneStrike = "178";
    private final String answerTwoStrike = "129";
    private final String answerThreeStrike = "123";
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
        String actual = baseBall.validateAnswer(anyInput, answerNoting);

        assertEquals("낫싱", actual, "입력값 중 정답과 같은 숫자가 한개도 없으면 '낫싱'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 1볼인 상태를 판단할 수 있다.")
    void validateOneBall(){
        String actual = baseBall.validateAnswer(anyInput, answerOneBall);

        assertEquals("0스트라이크 1볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 1개 있으면 '1볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 2볼인 상태를 판단할 수 있다.")
    void validateTwoBall(){
        String actual = baseBall.validateAnswer(anyInput, answerTwoBall);

        assertEquals("0스트라이크 2볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 2개 있으면 '2볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 3볼인 상태를 판단할 수 있다.")
    void validateThreeBall(){
        String actual = baseBall.validateAnswer(anyInput, answerThreeBall);

        assertEquals("0스트라이크 3볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 3개 있으면 '3볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 1스트라이크인 상태를 판단할 수 있다.")
    void validateOneStrike(){
        String actual = baseBall.validateAnswer(anyInput, answerOneStrike);

        assertEquals("1스트라이크 0볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 1개 있으면 '1볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 2스트라이크인 상태를 판단할 수 있다.")
    void validateTwoStrike(){
        String actual = baseBall.validateAnswer(anyInput, answerTwoStrike);

        assertEquals("2스트라이크 0볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 2개 있으면 '2볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 3스트라이크인 상태를 판단할 수 있다.")
    void validateThreeStrike(){
        String actual = baseBall.validateAnswer(anyInput, answerThreeStrike);

        assertEquals("3스트라이크 0볼", actual, "입력값 중 자릿수는 틀리고 일치하는 숫자가 3개 있으면 '3볼'인 상태를 반환해야 한다.");
    }
}
