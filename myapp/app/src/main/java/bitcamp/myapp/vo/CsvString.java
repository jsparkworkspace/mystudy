package bitcamp.myapp.vo;

// caller : CSV 문자열을 받아서 파일에 저자아는 측
// callee : 도메인 객체(Domain) = 값 객체(Value Object) = 데이터 전송 객체(Data Transfer Object)
public interface CsvString {

  String toCsvString();
}
