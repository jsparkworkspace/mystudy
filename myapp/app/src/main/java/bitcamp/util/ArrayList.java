package bitcamp.util;

import java.util.Arrays;

public class ArrayList<E> extends AbstractList<E> {

  private Object[] objects = new Object[3];

  public void add(E object) {
    if (this.size == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      this.objects = Arrays.copyOf(this.objects, newSize);
    }

    this.objects[this.size++] = object;
  }

  public E remove(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object deleted = this.objects[index];

    System.arraycopy(this.objects, index + 1, this.objects, index, this.size - (index + 1));

    this.objects[--this.size] = null;

    return (E) deleted;
  }

  public Object[] toArray() {
    return Arrays.copyOf(this.objects, this.size);
  }

  public boolean remove(E value) {
    for (int i = 0; i < this.size; i++) {
      if (this.objects[i].equals(value)) {
        this.remove(i);
        return true;
      }
    }
    return false;
  }

  public E[] toArray(E[] arr) {
    if (arr.length >= this.size) {
      System.arraycopy(this.objects, 0, arr, 0, this.size);
      return arr;
    }
    return (E[]) Arrays.copyOf(this.objects, this.size, arr.getClass());
  }

  public E get(int index) {
    if (index < 0 || index >= this.size) {
      return null;
    }
    return (E) this.objects[index];
  }

  public E set(int index, E object) {
    if (index < 0 || index >= this.size) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (E) old;
  }

  // 1) 외부에서 구현한 패키지 멤버 클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    return new ArrayListIterator<>(this);
//  }

  // 2) 스태틱 중첩 클래스를 사용한 경우
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(this);
//  }

  /*private static class IteratorImpl<E> implements Iterator<E> {

    ArrayList<E> list;
    int cursor = 0;

    public IteratorImpl(ArrayList<E> list) {
      this.list = list;
    }

    @Override
    public boolean hasNext() {
      return cursor >= 0 && cursor < list.size();
    }

    @Override
    public E next() {
      return list.get(cursor++);
    }
  }*/

  // 3) 논스태틱 중첩 클래스를 사용한 경우
  // 바깥 클래스의 인스턴스 주소를 두는 코드가 자동으로 추가된다.
//  @Override
//  public Iterator<E> iterator() {
//    return new IteratorImpl<>(/*this*/);
//  }
//
//  private class IteratorImpl<E> implements Iterator<E> {
//
//    /*ArrayList this$0;*/
//    int cursor = 0;
//
//    /*public IteratorImpl(ArrayList list) {
//      this$0 = list;
//    }*/
//
//    @Override
//    public boolean hasNext() {
//      return cursor >= 0 && cursor < ArrayList.this.size();
//    }
//
//    @Override
//    public E next() {
//      return (E) ArrayList.this.get(cursor++);
//    }
//  }

  // 4) 로컬 클래스를 사용하는 경우
//  @Override
//  public Iterator<E> iterator() {
//    //로컬 클래스는 이 메서드 안에서만 사용할 수 있다.
//    class IteratorImpl<E> implements Iterator<E> {
//
//      // 로컬 클래스도 non-static nested 클래스처럼
//      // 바깥 클래스의 인스턴스 주소를 저장하는 코드가 자동으로 추가된다.
//      int cursor = 0;
//
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//      }
//
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    }
//    return new IteratorImpl<>();
//  }

  // 5)익명 클래스
//  @Override
//  public Iterator<E> iterator() {
//    //익명 클래스는 이름이 없기 때문에 정의하는 즉시 인스턴스를 생성해야한다.
//    // 인스턴스 생성 구문 {} 형식으로 되어있으며 new 인스턴스의 인스턴스가 수퍼 클래스라는 것을 알 수 있고,
//    // 익명 클래스는 이름이 없기 때문에 생성자가 없으며, 수퍼 클래스의 생성자를 호출한다.
//    Iterator<E> obj = new Iterator<E>() {
//
//      // 익명 클래스도 non-static nested 클래스처럼
//      // 바깥 클래스의 인스턴스 주소를 저장하는 코드가 자동으로 추가된다.
//      int cursor = 0;
//
//      @Override
//      public boolean hasNext() {
//        return cursor >= 0 && cursor < ArrayList.this.size();
//      }
//
//      @Override
//      public E next() {
//        return (E) ArrayList.this.get(cursor++);
//      }
//    }; // 인스턴스를 생성했기 때문에 세미콜론을 넣어주어야한다.
//    return obj; //
//  }

  // 6) 익명 클래스를 사용한 경우 - 더 간결하게 표현하기
  @Override
  public Iterator<E> iterator() {
    Iterator<E> obj;
    return new Iterator<E>() {
      int cursor = 0;

      @Override
      public boolean hasNext() {
        return cursor >= 0 && cursor < ArrayList.this.size();
      }

      @Override
      public E next() {
        return (E) ArrayList.this.get(cursor++);
      }
    };
  }

}
