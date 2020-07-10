package kr.co.fastcampus.eatgo.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // 설정 : web에서 접속 가능한 컨트롤러
public class WelcomeController {

  @GetMapping("/") // HTTP에서 접속할 때 사용하는 메서드 설정
  public String hello(){
    return "Hello world!!!";
  }
}

