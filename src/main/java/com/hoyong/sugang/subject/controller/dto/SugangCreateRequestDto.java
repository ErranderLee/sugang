package com.hoyong.sugang.subject.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SugangCreateRequestDto {
  private Long userId;
  private Long subjectId;
}
