package com.xxl.job.executor.service.jobhandler;

import com.sun.net.httpserver.Authenticator;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author luojian
 */
@Component
public class MyJob {

    private static Logger logger = LoggerFactory.getLogger(MyJob.class);
    /**
     * 1、简单任务示例（Bean模式）
     */
    @XxlJob("myJob")
    public String demoJobHandler(String param) throws Exception {
        String jobParam = XxlJobHelper.getJobParam();
        for (int i = 0; i < 5; i++) {

            logger.info("--------------params:" +jobParam+"-"+ i+"-----------------");
        }
        return "success";
    }
}
