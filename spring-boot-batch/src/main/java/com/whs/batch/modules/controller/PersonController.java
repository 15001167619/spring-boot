package com.whs.batch.modules.controller;

import com.whs.batch.modules.entity.Person;
import com.whs.batch.modules.service.IPersonService;
import com.whs.batch.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:45
 */
@RestController
@RequestMapping("person")
@Slf4j
public class PersonController{

    @Autowired
    private IPersonService personService;
    /**
     * 新增用户
     */
    @RequestMapping(value="add", method= RequestMethod.POST)
    public String add(){
        personService.insert(new Person(1+(int)(Math.random()*20), CommonUtils.getRandomString(3)));
        return "success";
    }

}
