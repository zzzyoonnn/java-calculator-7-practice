package calculator.domain;

public class Delimiter {
  private static final String DEFAULT_DELIMITER = ",|;";
  private String customDelimiter;

  public String getDelimiter() {
    if (customDelimiter != null) {
      return DEFAULT_DELIMITER + "|" + customDelimiter;
    }
    return DEFAULT_DELIMITER;
  }

  public String parse(String input) {
    if (!input.startsWith("//")) return input;

    validateCustomDelimiterFormat(input);

    customDelimiter = input.substring(2, input.indexOf("\\n"));
    return input.substring(input.indexOf("\\n") + 2);
  }

  private void validateCustomDelimiterFormat(String input) {
    if (!input.contains("\\n")) throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
  }
}
