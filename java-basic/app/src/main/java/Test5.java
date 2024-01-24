import java.util.Scanner;

public class Test5 {

  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    Test test = new Test();
    test.printNum();
  }
}


class ScannerTest {

  public Scanner scanner() {
    Scanner sc = new Scanner(System.in);
    return sc;
  }
}


class Test {

  public void printNum() {
    // ScannerTest scannerTest = new ScannerTest();
    Scanner sc = new ScannerTest().scanner();

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n; j++) {
        if (i % 2 == 0) {
          System.out.print(j + 1);
        } else {
          System.out.print(n - j);
        }
      }
      System.out.println();
    }

    sc.close();
  }
}
