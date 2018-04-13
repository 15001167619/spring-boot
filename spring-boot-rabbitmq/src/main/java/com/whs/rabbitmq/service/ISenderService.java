package com.whs.rabbitmq.service;

/**
 * @author 武海升
 * @version 2.0
 * @description 生产者
 * @date 2018-04-13 10:14
 */
public interface ISenderService {

    void broadcast(String message);

    void direct(String message);

}
