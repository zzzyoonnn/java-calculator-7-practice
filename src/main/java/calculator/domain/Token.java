package calculator.domain;

import java.util.regex.Pattern;

public class Token {
  private final String[] tokens;

  public Token(String input, String delimiter) {
    validateInput(input, delimiter);
    this.tokens = input.split(delimiter);
  }

  public int[] getTokens() {
    int[] result = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      String s = tokens[i].isEmpty() ? "0" : tokens[i];
      result[i] = validateParseInt(s);
    }
    return result;
  }

  private static int validateNotNegative(int token) {
    if (token < 0) throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
    return token;
  }

  private static int validateParseInt(String s) {
    try {
      int temp = Integer.parseInt(s);

      return validateNotNegative(temp);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("int형 범위를 초과했습니다: " + s);
    }
  }

  private void validateInput(String input, String delimiter) {
    String escapedDelimiter = Pattern.quote(delimiter);
    String pattern = "\\d+(" + escapedDelimiter + "\\d+)*";

    if (!input.matches(pattern)) {
      throw new IllegalArgumentException("숫자와 구분자 이외의 문자열이 포함되어 있습니다.");
    }
  }
}
