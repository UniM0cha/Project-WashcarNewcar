package com.solstice.washcar_newcar.service.impl;

import org.springframework.stereotype.Service;

import com.solstice.washcar_newcar.data.entity.Store;
import com.solstice.washcar_newcar.data.entity.User;
import com.solstice.washcar_newcar.data.repository.UserRepository;
import com.solstice.washcar_newcar.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

}
