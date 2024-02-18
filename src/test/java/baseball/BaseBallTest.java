package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BaseBallTest {
    private final String anyInput = "123";
    private final String answer = "789";
    private final BaseBall baseBall = new BaseBall();
    @Test
    @DisplayName("사용자가 입력한 숫자와 정답으로 생성된 숫자는 3자리 이며 모두 서로 다른 숫자이다.")
    void generateAnswerDifferentNumber() {
        NumberValidate validate = new NumberValidate();

        assertTrue(validate.validateNumber("123"));
        assertTrue(validate.validateNumber("981"));
        assertFalse(validate.validateNumber("112"));
        assertFalse(validate.validateNumber("12"));
        assertFalse(validate.validateNumber("1234"));
    }

    @Test
    @DisplayName("스트라이크를 판단할 수 있다.")
    void calculateStrike(){
       assertEquals(1, baseBall.calculateStrike("701", answer), "1스트라이크 임을 판단할 수 있다.");
       assertEquals(2, baseBall.calculateStrike("781", answer), "2스트라이크 임을 판단할 수 있다.");
       assertEquals(3, baseBall.calculateStrike("789", answer), "3스트라이크 임을 판단할 수 있다.");
    }

    @Test
    @DisplayName("볼을 판단할 수 있다.")
    void calculateBall(){
        assertEquals(1, baseBall.calculateBall("127", answer), "1볼 임을 판단할 수 있다.");
        assertEquals(2, baseBall.calculateBall("917", answer), "2볼 임을 판단할 수 있다.");
        assertEquals(3, baseBall.calculateBall("978", answer), "3볼 임을 판단할 수 있다.");
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

    @Test
    @DisplayName("입력받은 숫자가 1스트라이크 1볼인 상태를 판단할 수 있다.")
    void validateOneStrikeOneBall(){
        String actual = baseBall.validateAnswer(anyInput, "192");

        assertEquals("1스트라이크 1볼", actual, "입력값 중 동일한 위치의 숫자가 1개 있으며 자릿수는 일치하지 않으며 동일한 숫자가 1개 있으면 '1스트라이크 1볼'인 상태를 반환해야 한다.");
    }

    @Test
    @DisplayName("입력받은 숫자가 1스트라이크 2볼인 상태를 판단할 수 있다.")
    void validateOneStrikeTwoBall(){
        String actual = baseBall.validateAnswer(anyInput, "132");

        assertEquals("1스트라이크 2볼", actual, "입력값 중 동일한 위치의 숫자가 1개 있으며 자릿수는 일치하지 않으며 동일한 숫자가 2개 있으면 '1스트라이크 2볼'인 상태를 반환해야 한다.");
    }

}
