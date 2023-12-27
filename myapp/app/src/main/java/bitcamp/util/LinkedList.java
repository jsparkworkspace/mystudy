package bitcamp.util;

public class LinkedList<E> {

  private Node<E> first;
  private Node<E> last;
  private int size;

  public int size() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void add(E value) {
    Node<E> node = new Node<>();
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
    Node<E> node = first;
    while (node != null) {
      arr[index++] = node.value;
      node = node.next;
    }
    return arr;
  }

  public E get(int index) /*throws IndexOutOfBoundsException*/ {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    return node.value;
  }

  public E set(int index, E value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    int cursor = 0;
    Node<E> node = first;
    while (++cursor <= index) {
      node = node.next;
    }

    E old = node.value;
    node.value = value;
    return old;
  }

  public void add(int index, E value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    Node<E> node = new Node<>();
    node.value = value;

    if (first == null) {
      first = last = node;
    } else if (index == 0) {
      // index가 0일 때,
      node.next = first;
      first = node;
    } else if (index == size) {
      // index가 size일 때,
      last.next = node;
      last = node;
    } else {
      // index가 중간일 때
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      node.next = currNode.next;
      currNode.next = node;
    }
    size++;
  }

  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("무효한 인덱스입니다.");
    }

    E old = null;

    if (size == 1) {
      old = first.value;
      first = last = null;

    } else if (index == 0) {
      old = first.value;
      first = first.next;

    } else {
      // 공통된 부분을 추출 - 리펙토링
      int cursor = 0;
      Node<E> currNode = first;
      while (++cursor < index) {
        currNode = currNode.next;
      }
      old = currNode.next.value;
      currNode.next = currNode.next.next;

      if (index == (size - 1)) {
        last = currNode;
      }
    }

    size--;
    return old;
  }

  public boolean remove(E value) {
    Node prevNode = null; // 이전 노드 저장
    Node node = first; // 찾은 노드는 node에 저장

    while (node != null) {
      if (node.value.equals(value)) {
        break;
      }
      prevNode = node;
      node = node.next;
    }
    // 받은 value와 동일한 value를 가진 노드가 없는 경우 false 리턴
    if (node == null) {
      return false;
    }
    // 첫번째 노드를 삭제하는 경우
    if (node == first) {
      first = first.next;
      if (first == null) {
        last = null;
      }
    } else {
      // 이전 노드와 삭제 대상 다음 노드를 연결
      prevNode.next = node.next;
    }
    // 노드가 하나밖에 없는 경우
    size--;
    return true;
  }

  private static class Node<E> {

    E value;
    Node<E> next;
  }
}
