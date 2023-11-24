package bitcamp.myapp;

public class App {

  public static void main(String[] args) {

    // 변수를 사용함으로써 메모리를 사용하게 됨
    // 변수의 메모리를 효율적으로 사용하도록 만드는 작업을 리펙토링이라고 한다.
    // 개발자의 투입시간을 절약해서 비용을 번다.
    // 반대로 유지보수를 포기하고 속도를 올리는 것을 옵티마이징이라고 함
    String ANSI_CLEAR = "\033[0m";
    String ANSI_BOLD_RED = "\033[1;31m";
    String ANSI_RED = "\033[0;31m";
    String appTitle = "[과제관리 시스템]";

    String menu1 = "1. 과제",
        menu2 = "2. 게시글",
        menu3 = "3. 도움말",
        menu4 = "4. 종료";

    System.out.println("-------------------------------------------");
    System.out.println(ANSI_BOLD_RED + appTitle + ANSI_CLEAR);
    System.out.println();
    System.out.println(menu1);
    System.out.println(menu2);
    System.out.println(menu3);
    System.out.println(ANSI_RED + menu4 + ANSI_CLEAR);
    System.out.println("-------------------------------------------");
  }


}
