package calculator.domain;

public class Calculator {
  private final Delimiter delimiter = new Delimiter();

  public String run(String input) {
    input = validateInput(input);

    Token token = new Token(input, delimiter.getDelimiter());
    return printResult(token.getTokens());
  }

  private String printResult(int[] tokens) {
    int result = 0;
    for (int token : tokens) {
      result += token;
    }
    return "결과 : " + result;
  }

  private String validateInput(String input) {
    input = delimiter.parse(input);

    if (input.isEmpty()) input = "0";

    String pattern = "\\d+((" + delimiter + ")\\d+)*";

    if (!input.matches(pattern)) {
      throw new IllegalArgumentException("올바르지 않은 입력값입니다: " + input);
    }

    return input;
  }
}
