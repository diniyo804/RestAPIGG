package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.domain.RestaurantsRepository;
import kr.co.fastcampus.eatgo.domain.RestaurantsRepositoryImpl;
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

//  @SpyBean
/* 실질적 구현이 없는 interface를 spy로 넣어 주는 것이므로 테스트 실행시 에러가 난다.
어떤 구현체를 사용할 건지 명시해주어야한다.
테스트 시 RestaurantsRepositoryImpl 외의 다른 클래스로 변경이 쉬워짐. */
  @SpyBean(RestaurantsRepositoryImpl.class)
  private RestaurantsRepository restaurantsRepository;

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