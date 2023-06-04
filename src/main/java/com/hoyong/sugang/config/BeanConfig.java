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

  @Bean
  public SugangService sugangService(
      UserSubjectRepository userSubjectRepository,
      UserFindOneService userFindOneService,
      SubjectFindOneService subjectFindOneService
  ) {
    return new SugangNaiveServiceImpl(
        userSubjectRepository,
        userFindOneService,
        subjectFindOneService
    );
  }

}
