package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* @RestController도 @Component의 일종이다.
controller의 instance를 만든 적이 없지만 controller가 실행된 이유는
스프링이 @RestController 컴포넌트를 직접 관리했기 때문이다. */
@RestController
public class RestaurantController {

  @Autowired
  private RestaurantsRepository repository;

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
