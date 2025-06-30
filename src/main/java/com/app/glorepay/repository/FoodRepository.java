package com.app.glorepay.repository;

import com.app.glorepay.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// make this into a food repository
@Repository
public interface FoodRepository extends JpaRepository<Food, Long> {
    public Food findByfoodId(Long foodId);
}
