package bitcamp.util;

public class ObjectRepository<dataType> {

  //수퍼 클래스의 레퍼런스는 서브 클래스의 인스턴스 주소를 담을 수 있다.
  // 따라서 Object 레퍼런스는 Member, Board, Assignment등 어떤 객체의 주소라도 담을 수 있다.
  private Object[] objects = new Object[3];
  private int length = 0;

  public void add(dataType object) {
    // 이관
    if (this.length == this.objects.length) {
      int oldSize = this.objects.length;
      int newSize = oldSize + (oldSize >> 1);

      Object[] arr = new Object[newSize];
      for (int i = 0; i < oldSize; i++) {
        arr[i] = this.objects[i];
      }

      this.objects = arr;
    }
    this.objects[this.length++] = object;
  }

  public dataType remove(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object deleted = this.objects[index];

    for (int i = index; i < (this.length - 1); i++) {
      this.objects[i] = this.objects[i + 1];
    }
    this.objects[--this.length] = null;

    return (dataType) deleted;
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < this.length; i++) {
      arr[i] = this.objects[i];
    }
    return arr;
  }

  public void toArray(dataType[] arr) {
    for (int i = 0; i < this.length; i++) {
      arr[i] = (dataType) this.objects[i];
    }
  }

  public dataType get(int index) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    return (dataType) this.objects[index];
  }

  public dataType set(int index, dataType object) {
    if (index < 0 || index >= this.length) {
      return null;
    }

    Object old = this.objects[index];
    this.objects[index] = object;

    return (dataType) old;
  }

  public int size() {
    return this.length;
  }


}

