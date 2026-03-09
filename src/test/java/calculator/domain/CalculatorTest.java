package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
   void 숫자로_시작하지_않는_입력_예외() {
    Calculator calculator = new Calculator();
    assertThatThrownBy(() -> calculator.run("a1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 빈_문자열_처리() {
    Calculator calculator = new Calculator();
    assertThat(calculator.run("")).contains("결과 : 0");
  }

  @Test
  void 빈_문자열이_포함된_입력_처리() {
    Calculator calculator = new Calculator();
    assertThat(calculator.run("1,2,,3;;4;5")).contains("결과 : 15");
  }
}
