package cn.whs.jwt.core;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:42
 */
public class BaseController {
    protected static SuccessPrompt SUCCESS_PROMPT = new SuccessPrompt();

    public  <T> Map<String, Object> findDataPage(Page<T> page) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());//总记录数
        map.put("pages", page.getPages());//总页码数
        map.put("current", page.getCurrent());//当前页码数
        map.put("list", page.getRecords());//返回记录内容
        map.put("size", page.getSize());//每页记录数
        return map;
    }
}
