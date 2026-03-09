package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
  static String defaultDelimiter = ",|;";
  static String customDelimiter;

  public static void main(String[] args) {
    // TODO: 프로그램 구현

    System.out.println("덧셈할 문자열을 입력해주세요.");
    String input = Console.readLine();
    System.out.println(input);

    // Calculator 역할
    input = validateInput(input);

    String delimiter = defaultDelimiter;

    if (customDelimiter != null) {
      delimiter += "|" + customDelimiter;
    }

    String[] tokens = input.split(delimiter);

    System.out.print(printResult(tokens));

  }

  public static String printResult(String[] tokens) {
    int result = 0;
    int token;
    for (String s : tokens) {
      if (s.isEmpty()) s = "0";

      token = validateParseInt(s);
      result += token;
    }

    return "결과 : " + result;
  }

  private static String validateInput(String input) {
    //커스텀인지 판단
    if (input.startsWith("//")) input = validateCustomDelimiterFormat(input);

    // 숫자로 시작할 경우, true
    if (Character.isDigit(input.charAt(0))) {
      return input;
    }

    throw new IllegalArgumentException("올바르지 않은 입력값입니다: " + input);
  }

  private static String validateCustomDelimiterFormat(String input) {
    if (!input.contains("\\n")) throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");

    customDelimiter = input.substring(2, input.indexOf("\\n"));
    input = input.substring(input.indexOf("\\n") + 2);
    return input;
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
