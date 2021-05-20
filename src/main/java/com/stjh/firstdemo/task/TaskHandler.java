package com.stjh.firstdemo.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.core.log.XxlJobLogger;
import org.springframework.stereotype.Component;

/**
 *
 * 任务Handler示例（Bean模式）
 * <p>
 * 开发步骤：
 * 1、注册到Spring容器：添加“@Component”注解，被Spring容器扫描为Bean实例；
 * 2、注册到执行器工厂：添加“@XxlJob(value="自定义jobhandler名称")”注解，注解value值对应的是调度中心新建任务的JobHandler属性的值。
 * 3、执行日志：需要通过 "XxlJobLogger.log" 打印执行日志；
 * @Author: wuge
 * @Date: 2020/9/21
 */
@Component
public class TaskHandler {

    @XxlJob("demoJobHandler")
    public ReturnT<String> demoJobHandler(String param) {
        XxlJobLogger.log("XXL-JOB, Hello World. param: " + param);
        return ReturnT.SUCCESS;
    }
}
