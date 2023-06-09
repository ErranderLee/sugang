package com.hoyong.sugang.subject.dto;

public class SugangCreateTestRequestDto {
  private Long userId;
  private Long subjectId;

  public SugangCreateTestRequestDto() {}
  public SugangCreateTestRequestDto(Long userId, Long subjectId) {
    this.userId = userId;
    this.subjectId = subjectId;
  }

  public Long getUserId() {
    return this.userId;
  }

  public Long getSubjectId() {
    return this.subjectId;
  }
}
