package com.hoyong.sugang.usersubject.entity;

import com.hoyong.sugang.subject.entity.Subject;
import com.hoyong.sugang.user.entity.User;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserSubject {
  @EmbeddedId
  private UserSubjectId id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  @MapsId("userId")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "subject_id")
  @MapsId("subjectId")
  private Subject subject;

  public UserSubject(User user, Subject subject) {
    this.user = user;
    this.subject = subject;
  }
}
