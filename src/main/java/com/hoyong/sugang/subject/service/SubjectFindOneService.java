package com.hoyong.sugang.subject.service;

import com.hoyong.sugang.subject.entity.Subject;
import com.hoyong.sugang.subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SubjectFindOneService {
  private final SubjectRepository subjectRepository;

  @Transactional(readOnly = true)
  public Subject findOne(Long subjectId) {
    return subjectRepository.findById(subjectId).orElseThrow(() -> new RuntimeException("Subject Not Found"));
  }

}
