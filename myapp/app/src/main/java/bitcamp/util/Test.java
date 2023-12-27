package bitcamp.util;

public class Test {

  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.add(new String("aaa"));
    list.add(new String("bbb"));
    list.add(new String("ccc"));
    list.add(new String("ddd"));

    list.remove(2); // aaa, bbb, ddd,
    list.remove(2); // aaa, bbb,
    list.remove(0); // bbb,
    list.remove(0);

    /*list.add(0, new String("xxx"));
    list.add(5, new String("yyy"));
    list.add(1, new String("mmm"));
    list.add(3, new String("ttt"));
    list.add(7, new String("ppp"));*/

    Object[] arr = list.toArray();
    for (Object value : arr) {
      System.out.println(value);
    }
    System.out.println();

   /* System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(3));
    System.out.println(list.get(4)); // 예외 발생*/

  }
}
