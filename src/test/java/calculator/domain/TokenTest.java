package calculator.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class TokenTest {

  @Test
  void 기본_구분자_토큰_분리() {
    Token token = new Token("1,2,3", ",|:");
    assertThat(token.getTokens()).containsExactly(1, 2, 3);
  }

  @Test
  void int형_범위_초과_예외() {
    Token token = new Token("2147483648,2,3", ",|:");
    assertThatThrownBy(() -> token.getTokens())
            .isInstanceOf(IllegalArgumentException.class);
  }
}
