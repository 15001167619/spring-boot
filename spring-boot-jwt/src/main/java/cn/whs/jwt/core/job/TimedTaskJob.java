package cn.whs.jwt.core.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * 定时任务
 * http://cron.qqe2.com/
 * 第一位，表示秒，取值0-59
 * 第二位，表示分，取值0-59
 * 第三位，表示小时，取值0-23
 * 第四位，日期天/日，取值1-31
 * 第五位，日期月份，取值1-12
 * 第六位，星期，取值1-7，1表示星期天，2表示星期一
 * 第七位，年份，可以留空，取值1970-2099
 * @date 2018-03-22 18:10
 */
@Component
@Slf4j
public class TimedTaskJob {

    @Scheduled(cron = "0/25 * * * * ?")
    public void checkState1() {
        log.info(">>>>> 开始执行定时任务....");
    }

}
