package kr.co.fastcampus.eatgo.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
class를 spring이 직접 관리한다.
RestaurantsRepository를 사용하는 곳에서 직접 객체를 만들지 않고 @Autowired를 붙여주면
controller를 만들 때 spring이 알아서 repository를 생성해서 넣어준다.
*/
@Component
public class RestaurantsRepository {
  // restaurant 의 collection, 저장소 즉 repository 라고 한다.
  // domain layer 에 속한다.

  List<Restaurant> restaurants = new ArrayList<>();

  public RestaurantsRepository() {
    restaurants.add(new Restaurant(1004L, "Bob zip", "seoul"));
    restaurants.add(new Restaurant(2020L, "Cyber Food", "seoul"));
  }

  public List<Restaurant> findAll() {
    return restaurants;
  }

  public Restaurant findById(Long id) {
    return restaurants.stream()
            .filter(r -> r.getId().equals(id)) // 받은 id와 같은 애를 찾아서
            .findFirst() // 첫번째 요소를 get
            // .get();
            .orElse(null); // 찾을 수 없는 경우도 처리하고싶을 때, null을 return하겠다.
  }
}
