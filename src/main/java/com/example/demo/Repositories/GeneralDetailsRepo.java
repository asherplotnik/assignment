package com.example.demo.Repositories;

import com.example.demo.entities.GeneralDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralDetailsRepo extends JpaRepository<GeneralDetails,Integer> {
}
