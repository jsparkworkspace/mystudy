package bitcamp.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c02_3")
public class Controller02_3 {

  // 테스트
  // http://localhost:8888/app2/c02_3/h1/aaa/111/ok
  @GetMapping(
      value="h1/{name}/{tel}/{gender}",
      produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler1(
      @PathVariable String name,
      @PathVariable String tel,
      @PathVariable String gender) {

    return String.format("name: %s\n tel: %s \n gender: %s",
        name, tel, gender);
  }

  // 테스트
  // 정규표현식에 맞는 요청 : http://localhost:8888/app2/c02_3/h2/aaa/010-111-2222/man
  // 정규표현식에 벗어난 요청 : http://localhost:8888/app2/c02_3/h2/aa-a/010-111-2222/man
  //                        http://localhost:8888/app2/c02_3/h2/aaa/111-2222/man
  //                        http://localhost:8888/app2/c02_3/h2/aaa/011-111-2222/testa
  @GetMapping(
      value="h2/{name:[a-zA-Z0-9]+}/{tel:[0-9]+-[0-9]+-[0-9]+}/{gender:man|woman}",
      produces="text/plain;charset=UTF-8")
  @ResponseBody
  public String handler2(
      @PathVariable String name,
      @PathVariable String tel,
      @PathVariable String gender) {

    // 패스 변수를 사용할 때,
    // 패스 변수의 값 규칙을 정규표현식으로 정의할 수 있다.
    // 정규 표현식에 어긋간 URL의 경우 예외가 발생할 것이다.
    //
    return String.format("name: %s\n tel: %s \n gender: %s",
        name, tel, gender);
  }

}
