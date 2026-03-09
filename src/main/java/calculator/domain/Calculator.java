package calculator.domain;

public class Calculator {
  private final Delimiter delimiter = new Delimiter();

  public String run(String input) {
    input = validateInput(input);
    System.out.println("input: " + input);

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

    // 숫자로 시작할 경우, true
    if (Character.isDigit(input.charAt(0))) {
      return input;
    }

    throw new IllegalArgumentException("올바르지 않은 입력값입니다: " + input);
  }
}
