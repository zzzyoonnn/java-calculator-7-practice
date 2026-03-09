package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class DelimiterTest {

  @Test
  void 기본_구분자_반환() {
    Delimiter delimiter = new Delimiter();
    assertThat(delimiter.getDelimiter()).isEqualTo(",|:");
  }

  @Test
  void 커스텀_구분자_파싱() {
    Delimiter delimiter = new Delimiter();
    delimiter.parse("//;\\n1;2;3");
    assertThat(delimiter.getDelimiter()).isEqualTo(",|:|;");
  }

  @Test
  void 커스텀_구분자_형식_오류() {
    Delimiter delimiter = new Delimiter();
    assertThatThrownBy(() -> delimiter.parse("//;1;2;3"))
            .isInstanceOf(IllegalArgumentException.class);
  }
}
