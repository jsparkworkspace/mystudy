public class ClassTest {

  void instanceMethod() {
    staticMethod(); // 동일 클래스 멤버에서는 앞에 클래스명 없이 스태틱 메서드 호출 가능
  }

  void instanceMethod2() {
    instanceMethod(); // 동 클래스 멤버에서는 객체 생성 없이 인스턴스 메서드 호출 가능
    ClassTest classTest = new ClassTest();
    classTest.instanceMethod();
  }

  static void staticMethod() {
    // instanceMethod(); // 스태틱 메서드에서 인스턴스 메서드 호출은 객체 생성 없이는 불가능
    ClassTest classTest = new ClassTest();
    classTest.instanceMethod();
  }

  static void staticMethod2() {
    staticMethod();
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}


class ClassTest2 {

}
