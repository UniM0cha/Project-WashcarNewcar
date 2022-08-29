package com.solstice.washcar_newcar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solstice.washcar_newcar.data.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
