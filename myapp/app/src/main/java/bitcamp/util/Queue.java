package bitcamp.util;

public class Queue<E> extends LinkedList<E> {

  public E offer(E value) {
    this.add(value);
    return value;
  }

  public E poll() {
    if (this.size == 0) {
      return null;
    }
    return this.remove(0);
  }

  public E peek() {
    if (this.size == 0) {
      return null;
    }
    return this.get(0);
  }
}
