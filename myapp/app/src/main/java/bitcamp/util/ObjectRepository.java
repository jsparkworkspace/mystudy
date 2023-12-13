package bitcamp.util;

import java.util.Arrays;

public class ObjectRepository<E> {

  //수퍼 클래스의 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있다.
  // 따라서 Object 레퍼런스는 Member, Board, Assignment등 어떤 객체의 주소라도 담을 수 있다.
  private Object[] objects = new Object[3];
  private int length = 0;

  public void add(E object) {
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

//      Object[] arr = new Object[newSize];
//      System.arraycopy(this.objects, 0, arr, 0, oldSize);
      this.objects = Arrays.copyOf(this.objects, newSize);
    }
    this.objects[this.length++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.length - (index + 1));
//    for (int i = index; i < (this.length - 1); i++) {
//      this.objects[i] = this.objects[i + 1];
//    }
    this.objects[--this.length] = null;

    return (E) deleted;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.length);
//    Object[] arr = new Object[this.length];
//    for (int i = 0; i < this.length; i++) {
//      arr[i] = this.objects[i];
//    }
//    return arr;
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.length) {
      System.arraycopy(this.objects, 0, arr, 0, this.length);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.length, arr.getClass());
//    for (int i = 0; i < this.length; i++) {
//      arr[i] = (E) this.objects[i];
//    }
  }

  public E get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }

  public int size() {
    return this.length;
  }


}

