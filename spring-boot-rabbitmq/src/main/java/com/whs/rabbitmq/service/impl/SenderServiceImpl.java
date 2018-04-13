package com.whs.rabbitmq.service.impl;

import com.whs.rabbitmq.service.ISenderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-13 10:15
 */
@Service
@Slf4j
public class SenderServiceImpl implements ISenderService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试广播模式.
     */
    @Override
    public void broadcast(String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("FANOUT_EXCHANGE", "", message, correlationData);
    }

    /**
     * 测试Direct模式.
     */
    @Override
    public void direct(String message) {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("DIRECT_EXCHANGE", "DIRECT_ROUTING_KEY", message, correlationData);
    }
}
