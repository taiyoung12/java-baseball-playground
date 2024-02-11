package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculateTest {
    @Test
    @DisplayName("더하기 테스트 함수")
    void addTest() {
        Calculate calculate = new Calculate();
        int result = calculate.add("2 3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("더하기 예외 상황 테스트 함수")
    void addExceptTest() {
        Calculate calculate = new Calculate();
        assertThatThrownBy(()-> calculate.add("a b"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }

    @Test
    @DisplayName("더하기 예외 상황 테스트 함수2")
    void addExceptTest2() {
        Calculate calculate = new Calculate();
        assertThatThrownBy(()-> calculate.add("1 b"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }


    @Test
    @DisplayName("빼기 테스트 함수")
    void subTest() {
        Calculate calculate = new Calculate();
        int result = calculate.sub("3 1");
        assertThat(result).isEqualTo(2);
    }

    @Test
    @DisplayName("빼기 예외 상황 테스트 함수2")
    void subExceptTest() {
        Calculate calculate = new Calculate();
        assertThatThrownBy(()-> calculate.sub("1 b"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");
    }

    @Test
    @DisplayName("곱하기 테스트 함수")
    void mulTest() {
        Calculate calculate = new Calculate();
        int result = calculate.mul("3 6");
        assertThat(result).isEqualTo(18);
    }

    @Test
    @DisplayName("곱하기 테스트 함수")
    void mulExceptTest() {
        Calculate calculate = new Calculate();
        assertThatThrownBy(()-> calculate.mul("1 b"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");

    }

    @Test
    @DisplayName("나누기 테스트 함수")
    void divTest() {
        Calculate calculate = new Calculate();
        int result = calculate.div("24 3");
        assertThat(result).isEqualTo(8);
    }
    @Test
    @DisplayName("0으로 나누기 테스트 함수")
    void divZeroTest() {
        Calculate calculate = new Calculate();
        int result = calculate.div("24 0");
        assertThat(result).isEqualTo(0);
    }
    @Test
    @DisplayName("0으로 나누기 테스트 함수")
    void divZeroTest2() {
        Calculate calculate = new Calculate();
        int result = calculate.div("0 24");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("나누기 테스트 함수")
    void divExceptTest() {
        Calculate calculate = new Calculate();
        assertThatThrownBy(()-> calculate.div("1 b"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("For input string");

    }

}
