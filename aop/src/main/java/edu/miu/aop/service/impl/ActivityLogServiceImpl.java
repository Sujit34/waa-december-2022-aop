package edu.miu.aop.service.impl;

import edu.miu.aop.dto.ActivityLogDto;
import edu.miu.aop.entity.ActivityLog;
import edu.miu.aop.repository.ActivityLogRepo;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl  implements ActivityLogService {
    private final ActivityLogRepo activityLogRepo;
    private final ModelMapper mapper;
    @Override
    public List<ActivityLogDto> getAll() {
        return activityLogRepo.findAll().stream().map(x -> mapper.map(x, ActivityLogDto.class)).toList();
    }

    @Override
    public ActivityLogDto getById(int id) {
        return mapper.map(activityLogRepo.findById(id).orElseThrow(() -> new RuntimeException("Activity Log with id " + id + " does not exist")), ActivityLogDto.class);
    }

    @Override
    public ActivityLogDto save(ActivityLogDto activityLogDto) {
        ActivityLog activityLog = mapper.map(activityLogDto, ActivityLog.class);
        return mapper.map(activityLogRepo.save(activityLog), ActivityLogDto.class);
    }
}
