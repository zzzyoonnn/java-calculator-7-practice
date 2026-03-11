package calculator.domain;

public class Token {
  private final String[] tokens;

  public Token(String input, String delimiter) {
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
}
