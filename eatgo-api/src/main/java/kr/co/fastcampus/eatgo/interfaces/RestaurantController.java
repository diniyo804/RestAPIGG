package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  //UI Layer는 사용자와 내부의 비지니스로직들이 서로 상관 없도록, 중간 징검다리 역할만 하는 코드만 들어가도록 한다.
  //뭔가 처리해야하는 부분들은 domain Layer에서 처리한다.

  private RestaurantsRepository repository = new RestaurantsRepository();

  @GetMapping("/restaurants")
  public List<Restaurant> list() {
    List<Restaurant> restaurants = repository.findAll();
    return restaurants;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
    Restaurant restaurant = repository.findById(id);
    return restaurant;
  }
}
