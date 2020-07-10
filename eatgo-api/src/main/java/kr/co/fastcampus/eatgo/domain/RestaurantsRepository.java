package kr.co.fastcampus.eatgo.domain;

import java.util.ArrayList;
import java.util.List;

public class RestaurantsRepository {
  // restaurant의 Collection, 저장소 즉 Repository라고 한다.
  // 도메인 레이어에 속한다.

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
