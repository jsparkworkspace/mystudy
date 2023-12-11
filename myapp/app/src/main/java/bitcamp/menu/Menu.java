package bitcamp.menu;

import bitcamp.util.Prompt;

// Menu를 처리하는 객체의 사용법을 정의한다.
public interface Menu {

  // 객체를 실행할 때 호출할 메서드를 선언한다.
  // 구현을 해서는 안된다.( 선언만 하고 블록을 넣지 않는다.)
  // => 추상 메서드
  public abstract void execute(Prompt prompt);

  // public abstract 는 default 값으로 생략가능하다.
  // 규칙은 공개해야하므로 무조건 public을 사용해야 한다.
  public abstract String getTitle();
}
