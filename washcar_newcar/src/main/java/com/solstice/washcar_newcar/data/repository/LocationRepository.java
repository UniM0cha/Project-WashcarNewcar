package com.solstice.washcar_newcar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solstice.washcar_newcar.data.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {

}
