package com.hoyong.sugang.subject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hoyong.sugang.IntegrationTest;
import com.hoyong.sugang.subject.dto.SugangCreateTestRequestDto;
import com.hoyong.sugang.subject.entity.Subject;
import com.hoyong.sugang.subject.repository.SubjectRepository;
import com.hoyong.sugang.user.entity.User;
import com.hoyong.sugang.user.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@Slf4j
public class SugangNaiveServiceTest extends IntegrationTest {
  @Autowired
  UserRepository userRepository;
  @Autowired
  SubjectRepository subjectRepository;
  @Autowired
  ApplicationContext applicationContext;
  @PersistenceContext
  EntityManager entityManager;

  private List<User> createUsers(int numberOfUsers) {
    return userRepository.saveAll(
        IntStream.range(1, numberOfUsers + 1).mapToObj(number -> new User("user" + number)).toList()
    );
  }

  private List<Long> getUserIds(List<User> users) {
    return users.stream().map(User::getId).toList();
  }

  private Subject createSubject(int total) {
    return subjectRepository.save(
        new Subject("소프트웨어공학", total)
    );
  }

  private String objectToJson(SugangCreateTestRequestDto testRequestDto) {
    try {
      return objectMapper.writeValueAsString(testRequestDto);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Test
  void test() throws InterruptedException {
    final int total = 60;
    final int numberOfAllUsers = 200;
    final Subject subject = createSubject(total);
    final List<User> users = createUsers(numberOfAllUsers);
    final List<Long> userIds = getUserIds(users);
    final int numberOfSugangUsers = 2;

    ExecutorService executorService = Executors.newFixedThreadPool(numberOfSugangUsers);
    IntStream.range(0, numberOfSugangUsers).forEach(number -> {
      executorService.execute(() -> {
        SugangCreateTestRequestDto testRequestDto = new SugangCreateTestRequestDto(userIds.get(number), subject.getId());
        try {
          mvc.perform(post("/sugang")
              .contentType(MediaType.APPLICATION_JSON)
              .content(objectToJson(testRequestDto))
          );
        } catch (Exception e) {
          log.error("=========================" + userIds.get(number) + "==========================");
          log.error(String.valueOf(number));
          e.printStackTrace();
        }
      });
    });

    executorService.awaitTermination(5, TimeUnit.SECONDS);
    executorService.shutdown();

    entityManager.clear();

    Optional<Subject> result = subjectRepository.findById(subject.getId());
    int resultTotal = result.get().getTotal();
    log.info("result(여석) = {}", total);

    Assertions.assertThat(resultTotal).isEqualTo(total - numberOfSugangUsers);
  }
}
