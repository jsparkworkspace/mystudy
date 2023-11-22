package bitcamp.myapp;

public class test {
        public static void main(String[] args) {
            System.out.println("Hello,world!");
            System.out.println("줄바꿈문자 \n");
            System.out.println("Hello,\nworld!"); // 줄바꿈 문자
            System.out.println("커서를 처음으로 돌리는 문자 : \\r \r");
            System.out.println("Hello,\rabc"); // 커서(cursor)를 처음으로 돌리는 문자
            // 커서란? 문자를 출력할 위치를 가리키는 것.

            System.out.println("커서를 뒤로 한 칸 이동시키는 문자 \b");
            System.out.println("Hello,\b\b\bworld!"); // 커서를 뒤로 한 칸 이동시키는 문자
            System.out.println("탭 공간을 추가 \t");
            System.out.println("Hello,\tworld!"); // 탭 공간을 추가시키는 문자
            System.out.println("이건 뭐지 \f");
            System.out.println("Hello,\fworld!"); //
            System.out.println("Hello,\"w\"orld!"); // " 문자를 출력시키는 문자
            System.out.println("Hello,'w'orld!"); // "" 안에서 ' 문자는 그냥 적는다.
            System.out.println('\''); // ' 문자를 출력시키는 문자
            System.out.println('"'); // '' 안에서 " 문자는 그냥 적는다.
            System.out.println("c:\\Users\\user\\git"); // \ 문자를 출력시키는 문자

        }

}
