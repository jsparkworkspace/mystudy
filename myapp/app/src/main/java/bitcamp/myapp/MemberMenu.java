package bitcamp.myapp;

public class MemberMenu {

  static Member[] members = new Member[3];
  static int length = 0;

  static void printMenu() {
    System.out.println("[회원]");
    System.out.println("1. 등록");
    System.out.println("2. 상세조회");
    System.out.println("3. 변경");
    System.out.println("4. 삭제");
    System.out.println("5. 목록");
    System.out.println("0. 이전");
  }

  static void execute() {
    printMenu();

    while (true) {

      String input = Prompt.input("번호? ");
      switch (input) {
        case "1":
          add();
          break;
        case "2":
          view();
          break;
        case "3":
          modify();
          break;
        case "4":
          delete();
          break;
        case "5":
          list();
          break;
        case "0":
          return;
        case "menu":
          printMenu();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다!");
      }
    }

  }

  static void add() {
    System.out.println("회원 등록:");

    if (length == members.length) {
//      System.out.println("더이상 추가할 수 없습니다.");
//      return;
      int oldSize = members.length;
      int newSize = oldSize + (oldSize >> 1);
      Member[] arr = new Member[newSize];

      for (int i = 0; i < oldSize; i++) {
        arr[i] = members[i];
      }

      members = arr;

    }

    Member customer = new Member();

    customer.email = Prompt.input("이메일? ");
    customer.name = Prompt.input("이름? ");
    customer.password = Prompt.input("비밀번호? ");
    customer.joinDate = Prompt.input("가입일? ");

    members[length] = customer;
    length++;

  }

  static void view() {
    System.out.println("회원 조회");
    int index = Integer.parseInt(Prompt.input("회원 번호? "));

    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member customer = members[index];
    System.out.printf("이메일: %s\n", customer.email);
    System.out.printf("이름: %s\n", customer.name);
    System.out.printf("비밀번호: %s\n", customer.password);
    System.out.printf("가입일: %s\n", customer.joinDate);

  }

  static void modify() {
    System.out.println("회원 변경");
    int index = Integer.parseInt(Prompt.input("회원 번호? "));

    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    Member customer = members[index];

    customer.email = Prompt.input("이메일(%s)? ", customer.email);
    customer.name = Prompt.input("이름(%s)? ", customer.name);
    customer.password = Prompt.input("비밀번호(%s)? ", customer.password);
    customer.joinDate = Prompt.input("가입일(%s)? ", customer.joinDate);
  }

  static void delete() {
    System.out.println("회원 삭제");
    int index = Integer.parseInt(Prompt.input("회원 번호? "));

    if (index < 0 || index >= length) {
      System.out.println("회원 번호가 유효하지 않습니다.");
      return;
    }

    for (int i = index; i < length; i++) {
      members[i] = members[i + 1];
    }

    length--;
    members[length] = null;

//    customer.email = "";
//    customer.name = "";
//    customer.password = "";
//    customer.joinDate = "";
  }

  static void list() {
    System.out.println("회원 목록");
    System.out.println("이메일                이름        가입일");

    for (int i = 0; i < length; i++) {
      Member customer = members[i];
      System.out.printf("%-20s\t%-8s\t%s\n", customer.email, customer.name, customer.joinDate);
    }
  }

}
