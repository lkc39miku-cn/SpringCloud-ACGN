package com.hikari.manager;

import com.hikari.util.SpringUtils;
import com.hikari.util.ThreadPoolUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.TimerTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * AsyncManager
 * @author lkc39miku_cn
 */
public class AsyncManager {
    @Value("${async-manager.operate-delay-time}")
    private Integer OPERATE_DELAY_TIME = 10;

    private final ScheduledExecutorService scheduledExecutorService = SpringUtils.getBean("scheduledExecutorService");

    private static final AsyncManager ME = new AsyncManager();

    public static AsyncManager me() {
        return ME;
    }

    public void execute(TimerTask timerTask) {
        scheduledExecutorService.schedule(timerTask, OPERATE_DELAY_TIME, TimeUnit.SECONDS);
    }

    public void shutDown() {
        ThreadPoolUtils.shutdownAndAwaitTermination(scheduledExecutorService);
    }
}