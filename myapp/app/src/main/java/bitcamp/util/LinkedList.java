package bitcamp.util;

public class LinkedList {

  private Node first;
  private Node last;
  private int size;

  public void add(Object value) {
    Node node = new Node();
    node.value = value;

    if (last == null) {
      // 노드 객체가 없을 때, first에 노드 객체 주소를 넣는다.
      first = last = node;
    } else {
      // 기존에 노드 객체가 있을 때, 마지막 노드의 다음 노드로 새로 만든 노드를 가리키게 한다.
      last.next = node;
      last = node; // last 주소 갱신
    }
    size++;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size];
    int index = 0;
    Node node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public Object get(int index) /*throws IndexOutOfBoundsException*/ {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    return node.value;
  }
}
