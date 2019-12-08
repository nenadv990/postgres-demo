package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.GrpRoba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrpRobaRepository extends JpaRepository<GrpRoba, Long> {

}
