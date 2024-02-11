package study;

import java.util.function.IntBinaryOperator;

public class Calculate {
    // 공통 입력 문자열 파싱 로직
    private int[] parseNumbers(String input) {
        return java.util.Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public int add(String input){
        int[] numbers = parseNumbers(input);
        return java.util.Arrays.stream(numbers).sum();
    }

    public int sub(String input){
        int[] numbers = parseNumbers(input);
        return java.util.Arrays.stream(numbers, 1, numbers.length)
                .reduce(numbers[0], (a, b) -> a - b);
    }

    public int mul(String input){
        int[] numbers = parseNumbers(input);
        return java.util.Arrays.stream(numbers)
                .reduce(1, (a, b) -> a * b);
    }
    public int div(String input){
        int[] numbers = parseNumbers(input);
        return java.util.Arrays.stream(numbers, 1, numbers.length)
                .reduce(numbers[0], (a, b) -> {
                    if (a == 0 || b == 0) {
                        return 0;
                    }
                    return a / b;
                });
    }
}
