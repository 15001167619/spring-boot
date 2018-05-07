package com.whs.validcode.modules.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.whs.validcode.common.utils.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-25 14:29
 */
@Controller
public class IndexController {
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "getValidCode")
    public void getValidCode(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
        byte[] captchaChallengeAsJpeg;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String validCodeText = defaultKaptcha.createText();
            httpServletRequest.getSession().setAttribute("validCode", validCodeText);
            BufferedImage challenge = defaultKaptcha.createImage(validCodeText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

    @RequestMapping(value = "checkValidCode")
    public String checkValidCode(HttpServletRequest httpServletRequest,Model model,String validCode){
        if(ToolUtil.isEmpty(validCode)){
            model.addAttribute("info", "未填写验证码");
            return "login";
        }
        String srcValidCode = (String) httpServletRequest.getSession().getAttribute("validCode");
        if (!srcValidCode.equals(validCode)) {
            model.addAttribute("info", "错误的验证码");
        } else {
            model.addAttribute("info", "登录成功");
        }
        return "index";
    }

}
