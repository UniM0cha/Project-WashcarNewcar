package com.solstice.washcar_newcar.service.impl;

import org.springframework.stereotype.Service;

import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.StoreRepository;
import com.solstice.washcar_newcar.service.StoreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

  private final StoreRepository storeRepository;

  @Override
  public Store findByUser(User user) {
    return storeRepository.findByUser(user);
  }

}
