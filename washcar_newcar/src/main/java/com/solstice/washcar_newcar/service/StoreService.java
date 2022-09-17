package com.solstice.washcar_newcar.service;

import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;

public interface StoreService {
  public Store findByUser(User user);
}
