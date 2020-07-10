package kr.co.fastcampus.eatgo.interfaces;


import org.junit.jupiter.api.Test;g
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class) //== junit4의 RunWith 스프링을 이용해서 테스트를 실행
@WebMvcTest(RestaurantController.class) // 특정 컨트롤러의 테스트임을 명시한다.
public class RestaurantControllerTest {
  // controller test

  @Autowired
  private MockMvc mvc;

  @Test
  public void list() throws Exception {
    mvc.perform(get("/restaurants")).andExpect(status().isOk())
            .andExpect(content().string(containString("Bob zip")));

  }

}