package com.hoyong.sugang.subject.controller;

import com.hoyong.sugang.subject.controller.dto.SugangCreateRequestDto;
import com.hoyong.sugang.subject.service.SugangService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sugang")
public class SugangController {
  private final SugangService sugangService;

  public SugangController(SugangService sugangService) {
    this.sugangService = sugangService;
  }

  @PostMapping
  public void createSugang(@RequestBody SugangCreateRequestDto requestDto) {
    sugangService.createSugang(requestDto.getUserId(), requestDto.getSubjectId());
  }
}
