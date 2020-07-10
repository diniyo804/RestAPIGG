package kr.co.fastcampus.eatgo.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RestaurantTests {
/*
  [꿀팁]
   spring boot가 실행되는 동안 수정한 코드를 적용시키고 싶다면
   tdd를 실행해라! 그럼 수정된 부분이 빌드되어 적용됨 !
*/
  @Test
  public void creation(){
    Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
    assertThat(restaurant.getName()).isEqualTo("Bob zip");
    assertThat(restaurant.getAddress()).isEqualTo("Seoul");
  }

  @Test
  public void information(){
    Restaurant restaurant = new Restaurant("Bob zip", "Seoul");
    assertThat(restaurant.getInformation()).isEqualTo("Bob zip in Seoul");
  }

}