package edu.miu.aop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ActivityLogDto {
    private int id;
    private LocalDate date;
    private String operation;
    private long duration;
}
