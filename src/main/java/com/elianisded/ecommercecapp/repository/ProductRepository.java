package com.elianisded.ecommercecapp.repository;

import com.elianisded.ecommercecapp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
