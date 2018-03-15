package cn.whs.jwt.modules.core;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:48
 */
public class SuccessPrompt extends Prompt{

    public SuccessPrompt(){
        super.code = 200;
        super.message = "操作成功";
    }

}
