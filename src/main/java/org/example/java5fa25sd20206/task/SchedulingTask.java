package org.example.java5fa25sd20206.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.java5fa25sd20206.service.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@Slf4j
@RequiredArgsConstructor
public class SchedulingTask {

    private static final DateTimeFormatter dateTimeFormater =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final ProductService productService;


    //@Scheduled(cron = "0 * * * * ?")
    @Scheduled(cron = "*/10 * * * * ?")
    public void scheduleTaskWithCronExpression() {

        log.info("Cron Task: Time - {}", dateTimeFormater.format(LocalDateTime.now()));
        log.info("Products in DB - {}", productService.getAllProducts().size());
    }
}
