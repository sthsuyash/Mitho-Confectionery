package com.suyash.ecommerce.repository;

import com.suyash.ecommerce.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findAllByCategoryId(Long id);
}
