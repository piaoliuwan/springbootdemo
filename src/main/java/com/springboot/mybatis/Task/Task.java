package com.springboot.mybatis.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Task {
    //http://cron.qqe2.com/      任务调度的写法
    @Scheduled(cron="1-30 * * * * ? ")
    public void testTask(){
        System.out.println("时间---"+new Date());
    }
}
