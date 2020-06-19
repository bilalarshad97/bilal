package com.bilal.bilal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<com.bdms.bdms.entity.Product, Long> {
}
