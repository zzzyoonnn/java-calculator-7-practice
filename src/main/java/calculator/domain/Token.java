package calculator.domain;

public class Token {
  private final String[] tokens;

  public Token(String input, String delimiter) {
    validateInput(input, delimiter);
    this.tokens = input.split(delimiter);
  }

  public int[] getTokens() {
    int[] result = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      result[i] = validateParseInt(tokens[i]);
    }
    return result;
  }

  private static int validateParseInt(String s) {
    try {
      return Integer.parseInt(s);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("int형 범위를 초과했습니다: " + s);
    }
  }

  private void validateInput(String input, String delimiter) {
    String pattern = "\\d+((" + delimiter + ")\\d+)*";

    if (!input.matches(pattern)) {
      throw new IllegalArgumentException("숫자와 구분자 이외의 문자열이 포함되어 있습니다.");
    }
  }
}
