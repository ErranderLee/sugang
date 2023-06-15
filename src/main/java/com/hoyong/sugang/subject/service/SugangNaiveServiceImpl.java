package com.hoyong.sugang.subject.service;

import com.hoyong.sugang.subject.entity.Subject;
import com.hoyong.sugang.user.entity.User;
import com.hoyong.sugang.user.service.UserFindOneService;
import com.hoyong.sugang.usersubject.entity.UserSubject;
import com.hoyong.sugang.usersubject.repository.UserSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class SugangNaiveServiceImpl implements SugangService {
  private final UserSubjectRepository userSubjectRepository;
  private final UserFindOneService userFindOneService;
  private final SubjectFindOneService subjectFindOneService;

  @Override
  @Transactional
  public void createSugang(Long userId, Long subjectId) {
    User user = userFindOneService.findOne(userId);
    Subject subject = subjectFindOneService.findOne(subjectId);
    UserSubject userSubject = new UserSubject(user, subject);
    subject.reduceTotal();
    userSubjectRepository.flush();
    userSubjectRepository.save(userSubject);
  }
}
