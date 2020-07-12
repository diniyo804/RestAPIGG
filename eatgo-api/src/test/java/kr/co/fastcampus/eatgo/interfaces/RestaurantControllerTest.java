package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.domain.RestaurantsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class) //== junit4의 RunWith 스프링을 이용해서 테스트를 실행
@WebMvcTest(RestaurantController.class) // 특정 컨트롤러의 테스트임을 명시한다.
public class RestaurantControllerTest {
  // controller test

  @Autowired // 스프링에서 알아서 객체 생성
  private MockMvc mvc;

  //controller에 원하는 객체를 주입한다.
  @SpyBean
  private RestaurantsRepository restaurantsRepository;
  /* 실제 컨트롤러 테스트를위해 web mvc 테스트를 할 땐 제대로 된 저장소를 사용할 수 없기때문에
  테스트 진행 시 컨트롤러에 직접 의존성을 주입해주어야 한다.
  spring boot에서는 @SpyBean을 제공한다.
  controller에 원하는 객체를 주입할 수 있다.
   */

  @DisplayName("list content 확인")
  @Test
  public void list() throws Exception {
    mvc.perform(get("/restaurants"))
            .andExpect(status().isOk())
            .andExpect(content()
                    .string(
                            containsString("\"name\":\"Bob zip\"")))
            .andExpect(content()
                    .string(
                            containsString("\"id\":1004")));

  }
  @DisplayName("가게 상세")
  @Test
  public void detail() throws Exception {
    mvc.perform(get("/restaurants/1004"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                            containsString("\"name\":\"Bob zip\"")))
            .andExpect(content()
                    .string(
                            containsString("\"id\":1004")));

    mvc.perform(get("/restaurants/2020"))
            .andExpect(status().isOk())
            .andExpect(content().string(
                    containsString("\"name\":\"Cyber Food\"")))
            .andExpect(content()
                    .string(
                            containsString("\"id\":2020")));

  }

}