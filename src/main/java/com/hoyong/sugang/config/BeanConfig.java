package com.hoyong.sugang.config;

import com.hoyong.sugang.subject.service.SubjectFindOneService;
import com.hoyong.sugang.subject.service.SugangNaiveServiceImpl;
import com.hoyong.sugang.subject.service.SugangService;
import com.hoyong.sugang.user.service.UserFindOneService;
import com.hoyong.sugang.usersubject.repository.UserSubjectRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
  private UserSubjectRepository userSubjectRepository;
  private UserFindOneService userFindOneService;
  private SubjectFindOneService subjectFindOneService;

  @Bean
  public SugangService sugangService() {
    return new SugangNaiveServiceImpl(
        userSubjectRepository,
        userFindOneService,
        subjectFindOneService
    );
  }

}
