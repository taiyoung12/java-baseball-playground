package baseball;

public class NumberValidate {
    public boolean validateNumber(String answer) {
        long distinctDigits = answer.chars().distinct().count();
        return answer.length() == 3 && distinctDigits == 3;
    }
}
