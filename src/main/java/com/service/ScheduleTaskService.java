package com.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface ScheduleTaskService {

    public void init(LocalDate beginDate, LocalDate endDate);

    public void everyDayRun();
}
