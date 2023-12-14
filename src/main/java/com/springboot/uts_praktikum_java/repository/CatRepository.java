package com.springboot.uts_praktikum_java.repository;

import com.springboot.uts_praktikum_java.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
