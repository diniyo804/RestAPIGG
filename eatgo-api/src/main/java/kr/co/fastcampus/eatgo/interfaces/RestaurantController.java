package kr.co.fastcampus.eatgo.interfaces;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.RestaurantsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

  private RestaurantsRepository repository = new RestaurantsRepository();

  @GetMapping("/restaurants")
  public List<Restaurant> list() {

//    List<Restaurant> restaurants = new ArrayList<>();
//    restaurants.add(new Restaurant(1004L, "Bob zip", "seoul"));
    List<Restaurant> restaurants = repository.findAll();


    return restaurants;
  }

  @GetMapping("/restaurants/{id}")
  public Restaurant detail(@PathVariable("id") Long id) {
//    List<Restaurant> restaurants = new ArrayList<>();
//    restaurants.add(new Restaurant(1004L, "Bob zip", "seoul"));
//    restaurants.add(new Restaurant(2020L, "Cyber Food", "seoul"));
//    List<Restaurant> restaurants = repository.findAll();

//    Restaurant restaurant = restaurants.stream()
//            .filter(r -> r.getId().equals(id)) // 받은 id와 같은 애를 찾아서
//            .findFirst() // 첫번째 요소를 get
//           // .get();
//    .orElse(null); // 찾을 수 없는 경우도 처리하고싶을 때, null을 return하겠다.

   Restaurant restaurant = repository.findById(id);




    return restaurant;
  }
}
