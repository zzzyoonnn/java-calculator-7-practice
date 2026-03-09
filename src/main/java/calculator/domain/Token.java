package calculator.domain;

public class Token {
  private final String[] tokens;

  public Token(String input, String delimiter) {
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
}
