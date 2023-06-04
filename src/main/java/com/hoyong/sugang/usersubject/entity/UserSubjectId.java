package com.hoyong.sugang.usersubject.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class UserSubjectId implements Serializable {
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "subject_id")
  private Long subjectId;

  public UserSubjectId(Long userId, Long subjectId) {
    this.userId = userId;
    this.subjectId = subjectId;
  }
}
