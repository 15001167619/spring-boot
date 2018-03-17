package cn.whs.jwt.modules.controller;

import cn.whs.jwt.core.BaseController;
import cn.whs.jwt.core.exception.TipsException;
import cn.whs.jwt.core.exception.TipsRuntimeException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import static cn.whs.jwt.core.exception.ExceptionEnum.TEST;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-17 10:54
 */
@RestController
@RequestMapping("exception")
public class ExceptionController  extends BaseController {

    @ApiOperation(value="异常测试", notes="异常测试")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public Object test(@ApiParam(required = true, name = "id", value = "id值") @RequestParam(value = "id", defaultValue = "1") Integer id) throws TipsException {

        if(id == 1) {
            throw new TipsException("id不能为1");
        }else if(id == 2) {
            throw new TipsRuntimeException(TEST);
        }

        return SUCCESS_PROMPT;
    }

}
