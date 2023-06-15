package com.hoyong.sugang.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersistenceFlushService {

  @PersistenceContext
  private final EntityManager entityManager;

  public void flush() {
    entityManager.flush();
  }
}
