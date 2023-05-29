package com.hoyong.sugang.user.service;

import com.hoyong.sugang.user.entity.User;
import com.hoyong.sugang.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserFindOneService {
  private final UserRepository userRepository;

  @Transactional(readOnly = true)
  public User findOne(Long userId) {
    return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Not Found"));
  }
}
