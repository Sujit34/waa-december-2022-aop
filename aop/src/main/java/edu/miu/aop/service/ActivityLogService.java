package edu.miu.aop.service;

import edu.miu.aop.dto.ActivityLogDto;

import java.util.List;

public interface ActivityLogService {
    List<ActivityLogDto> getAll();
    ActivityLogDto getById(int id);
    ActivityLogDto save(ActivityLogDto activityLogDto);
}
