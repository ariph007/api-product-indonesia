package com.alpha.products.AlphaProducts.repository;

import com.alpha.products.AlphaProducts.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
  Optional<Product> findByBarcode(String barcode);
  List<Product> findAllByNameIsContainingIgnoreCase(String name);
}
