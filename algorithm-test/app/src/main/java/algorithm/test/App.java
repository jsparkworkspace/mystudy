/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package algorithm.test;

public class App {

  public static void main(String[] args) {
    String str1 = "apple";
    String str2 = "banana";

    int result = str1.compareTo(str2);
    System.out.println(result);

    if (result < 0) {
      System.out.println("str1 comes before str2");
    } else if (result > 0) {
      System.out.println("str1 comes after str2");
    } else {
      System.out.println("str1 and str2 are equal");
    }

  }
}
