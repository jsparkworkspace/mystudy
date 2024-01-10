// 객체 --> JSON 문자열 : Date 값을 yyyy-MM-dd 형식으로 출력하기
package com.eomcs.openapi.json.jackson;

import java.sql.Date;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Exam0311 {
  public static void main(String[] args) throws Exception {

    Project project = new Project();
    project.setNo(100);
    project.setTitle("자바 최종 프로젝트");
    project.setContent("자바 웹 애플리케이션");
    project.setStartDate(Date.valueOf("1970-1-1"));
    // sql.Date 타입은 날짜 정보만 다루기 때문에 TimeZone을 다루지 않는다.
    // GMT 시간인 1970-01-01 로 세터 호출 할 때 getTime()으로 밀리초를 보면 -9시간이 되어있는 것을 확인
    // 즉, 시스템 로케일(Asia/Seoul : GMT+9) 시간 만큼 빠져있다.
    // 세터에서 setTime(0)으로 설정해버리면 jsonStr도 1970-01-01 로 날짜가 동일하게 출력된다.

    // 이말은 세터가 파라미터로 날짜 정보를 받고 저장할 때
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    // 위 포맷에 따라 String으로 저장하는 과정에서 GMT 표준시 기준으로 시간을 반환한다.
    // 이 때 내 시스템 로케일 시간대인 GMT+9 시간이기 때문에
    // 표준시로 맞추기 위해 9시간에 대한 밀리초를 뺀다.
    project.setEndDate(Date.valueOf("2024-5-8"));

    ObjectMapper mapper = new ObjectMapper();
    String jsonStr = mapper.writeValueAsString(project);

    System.out.println(jsonStr);
  }
}


