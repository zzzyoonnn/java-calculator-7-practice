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
    input = isValidInput(input);

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
      if (s.equals("")) s = "0";

      token = Integer.parseInt(s);
      if (token < 0) throw new IllegalArgumentException();
      result += Integer.parseInt(s);
    }

    return "결과 : " + result;
  }

  public static String isValidInput(String input) {
//    // 빈 줄일 경우 0
//    if (input == null || input.isEmpty()) {
//      return "0";
//    }

    // '//'로 시작할 경우 일단 true -> 커스텀인지는 Delimiter가 판단
    if (input.startsWith("//")) {
      if (!input.contains("\\n")) throw new IllegalArgumentException();

      customDelimiter = input.substring(2, input.indexOf("\\n"));
      input = input.substring(input.indexOf("\\n") + 2);
      return input;
    }

    // 숫자로 시작할 경우, true
    if (Character.isDigit(input.charAt(0))) {
      return input;
    }


    // 그 외는 모두 error -> IllegalArgumentException
    throw new IllegalArgumentException();

  }

  public static String hasCustomDelimiter(String input) {
    if (input.startsWith("//") && input.contains("\n")) {
      customDelimiter = input.substring(2, input.indexOf("\n"));
      System.out.println("customDelimiter: " + customDelimiter);
      return input.substring(input.indexOf("\n") + 1);
    }

    throw new IllegalArgumentException();
  }
}
