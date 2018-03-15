package cn.whs.jwt.modules.controller;

import cn.whs.jwt.modules.core.BaseController;
import cn.whs.jwt.modules.entity.Person;
import cn.whs.jwt.modules.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:40
 */
@Controller
@RequestMapping(value = "person")
public class PersonController extends BaseController {

    @Autowired
    private IPersonService personService;

    /**
     * 新增用户
     */
    @RequestMapping(value = "add")
    @ResponseBody
    public Object add(Integer age,String name) {
        personService.insert(new Person(age,name));
        return SUCCESS_PROMPT;
    }

    /**
     * 获取全部用户列表
     */
    @RequestMapping(value = "list")
    @ResponseBody
    public Object allList(String name) {
        return this.personService.selectByName(name);
    }

    /**
     * 删除用户记录
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public Object delete(@RequestParam Integer personId) {
        this.personService.deletePerson(personId);
        return SUCCESS_PROMPT;
    }


}
