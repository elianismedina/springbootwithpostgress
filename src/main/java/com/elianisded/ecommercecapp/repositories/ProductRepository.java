package com.elianisded.ecommercecapp.repositories;

import com.elianisded.ecommercecapp.dto.ProductListDTO;
import com.elianisded.ecommercecapp.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;



import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.elianisded.ecommercecapp.dto.ProductListDTO(p.id, p.name, p.description, p.price, p.quantity, p.image) FROM Product p")
    Page<ProductListDTO> findAllWithoutComments(Pageable pageable);
}
