package com.hoyong.sugang.subject.repository;

import com.hoyong.sugang.subject.entity.Subject;
import java.util.Optional;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
  @Lock(LockModeType.PESSIMISTIC_WRITE)
  @Transactional
  Optional<Subject> findById(Long id);
}
