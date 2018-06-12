package com.starter.test.service;

import com.whs.starter.aspect.Log;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-06-12 10:27
 */
@Service
public class LogService {

    @Log
    public void test(int num,String name) {
        System.out.println("----test---- " + num  +":"+name);
    }

    @Log
    public void core(int num) {
        System.out.println("----core---- " + num);
    }

    public void work(int num) {
        System.out.println("----work---- " + num);
    }


}
