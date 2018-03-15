package cn.whs.jwt.modules.controller;

import cn.whs.jwt.modules.core.BaseController;
import cn.whs.jwt.modules.entity.Aaa;
import cn.whs.jwt.modules.service.IAaaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试控制器
 *
 * @Date 2018-03-06 18:42:39
 */
@Controller
@RequestMapping("/aaa")
public class AaaController extends BaseController {

    private String PREFIX = "/system/aaa/";

    @Autowired
    private IAaaService aaaService;


    /**
     * 获取测试列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return aaaService.selectList(null);
    }

    /**
     * 新增测试
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Aaa aaa) {
        aaaService.insert(aaa);
        return SUCCESS_PROMPT;
    }

    /**
     * 删除测试
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer aaaId) {
        aaaService.deleteById(aaaId);
        return SUCCESS_PROMPT;
    }

    /**
     * 修改测试
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Aaa aaa) {
        aaaService.updateById(aaa);
        return SUCCESS_PROMPT;
    }

    /**
     * 测试详情
     */
    @RequestMapping(value = "/detail/{aaaId}")
    @ResponseBody
    public Object detail(@PathVariable("aaaId") Integer aaaId) {
        return aaaService.selectById(aaaId);
    }
}
