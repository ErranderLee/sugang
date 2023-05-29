package com.hoyong.sugang.usersubject.repository;

import com.hoyong.sugang.usersubject.entity.UserSubject;
import com.hoyong.sugang.usersubject.entity.UserSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSubjectRepository extends JpaRepository<UserSubject, UserSubjectId> {

}
