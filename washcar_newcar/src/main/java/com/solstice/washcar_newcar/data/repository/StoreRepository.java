package com.solstice.washcar_newcar.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

public interface StoreRepository extends JpaRepository<Store, Long> {
  public Store findByUser(User user);
}
