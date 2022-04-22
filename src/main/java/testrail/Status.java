package testrail;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {
  PASSED(1), BLOCKED(2), UNTESTED(3), RETEST(4), FAILED(5);

  private int id;
}