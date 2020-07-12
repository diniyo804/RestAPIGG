package kr.co.fastcampus.eatgo.domain;

import java.util.List;

public interface RestaurantsRepository {
  List<Restaurant> findAll();

  Restaurant findById(Long id);
}
