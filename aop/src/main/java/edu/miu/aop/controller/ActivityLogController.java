package edu.miu.aop.controller;

import edu.miu.aop.dto.ActivityLogDto;
import edu.miu.aop.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity-logs")
@RequiredArgsConstructor
public class ActivityLogController {
    public final ActivityLogService activityLogService;
    @GetMapping
    public List<ActivityLogDto> getAll(){
        return activityLogService.getAll();
    }
    @GetMapping("/{id}")
    public ActivityLogDto getById(@PathVariable int id){
        return activityLogService.getById(id);
    }
    @PostMapping
    public ActivityLogDto save(@RequestBody ActivityLogDto activityLogDto){
        return activityLogService.save(activityLogDto);
    }
}
