package bitcamp.util;

public class Test {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.add(new String("aaa"));
    list.add(new String("bbb"));
    list.add(new String("ccc"));
    list.add(new String("ddd"));

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.println(value);
    }
  }
}
