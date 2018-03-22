package cn.whs.jwt;

import cn.whs.jwt.core.auth.controller.dto.AuthRequestImpl;
import cn.whs.jwt.core.auth.converter.BaseTransferEntity;
import cn.whs.jwt.core.auth.security.impl.Base64SecurityActionImpl;
import cn.whs.jwt.core.auth.util.JwtTokenUtil;
import cn.whs.jwt.core.config.properties.JwtProperties;
import cn.whs.jwt.core.redis.IRedisService;
import cn.whs.jwt.modules.entity.SysUser;
import cn.whs.jwt.modules.service.ISysUserService;
import cn.whs.jwt.utils.CommonUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-22 11:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringBootSignTest {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private IRedisService redisService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 获取Token以及签名
     */
    @Test
    public void generateTokenSignTest() {
        log.info("*********初始化用户**********");
        AuthRequestImpl authRequest = new AuthRequestImpl();
        authRequest.setMobile("15001167619");
        authRequest.setPassword("666");
        log.info("*********获取Token**********");
        final String randomKey = jwtTokenUtil.getRandomKey();
        final String token = jwtTokenUtil.generateToken(authRequest.getCredenceUniqueName(), randomKey);
        final String sign = jwtTokenUtil.generateSign(authRequest, randomKey);
        log.info("获取Token："+token);
        log.info("获取签名："+sign);
        log.info("*********保存服务器端签名 sign  **********");
        redisService.addToRedis(authRequest.getCredenceUniqueName()+"_SIGN",sign,jwtProperties.getExpiration());
    }
    /**
     * 客户端通过 请求数据+签名的方式传递加密数据到server服务端
     */
    @Test
    public void generateRequestData() {
        String sign = "19b5a7246b71a9d419179fb0dda1d2b8";
        log.info("############用户发送请求#################");
        SysUser sysUser = new SysUser(1+(int)(Math.random()*20),"whs"+ CommonUtils.getRandomString(3),CommonUtils.getRandomString(11),CommonUtils.getRandomString(6));
        String beforeJsonString = JSON.toJSONString(sysUser);
        log.info("############用户发送请求原始数据#################"+beforeJsonString);
        String encode = new Base64SecurityActionImpl().doAction(beforeJsonString);
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(sign);
        String afterJsonString = JSON.toJSONString(baseTransferEntity);
        log.info("############用户发送请求加密后数据#################"+afterJsonString);
    }
    /**
     * 服务端通过 签名+加密数据 解析客户端源数据
     */
    @Test
    public void analysisRequestData() {

        AuthRequestImpl authRequest = new AuthRequestImpl();
        authRequest.setMobile("15001167619");
        authRequest.setPassword("666");


        String token = "eyJhbGciOiJIUzUxMiJ9.eyJyYW5kb21LZXkiOiJ3Z2U4enQiLCJzdWIiOiIxNTAwMTE2NzYxOSIsImV4cCI6MTUyMTc4Mjg4NSwiaWF0IjoxNTIxNjk2NDg1fQ.DEAIUUZvEYmqoPmhAEvDHhiwK764SgmRQ37_6kbNA_ksHkWIN26gKZfZlGUR4axUOqzPrxauvogg8JvhV2FRdQ";
        String sign = "19b5a7246b71a9d419179fb0dda1d2b8";
        String requestData = "{\"object\":\"eyJhZ2UiOi0xMTkzOTU5NDY2LCJtb2JpbGUiOiJwcWxsZGdxYWt0NSIsIm5hbWUiOiJ3aHMzaWgiLCJwYXNzd29yZCI6Ijc3OGdrayJ9\",\"sign\":\"19b5a7246b71a9d419179fb0dda1d2b8\"}";
        log.info("############判断用户Token 是否失效 #################");
        Boolean tokenExpired = jwtTokenUtil.isTokenExpired(token);
        if(!tokenExpired){
            log.info("############用户Token 正常 #################");
            log.info("############判断用户签名 sign 是否失效 #################");
            String serverSign = redisService.getRedisValueByKey(authRequest.getCredenceUniqueName() + "_SIGN");
            if(CommonUtils.isNotBlank(serverSign)){
                if(sign.equals(serverSign)){
                    log.info("############用户签名 sign 正常 #################");
                    log.info("############ 解析数据  #################");
                    JSONObject jsonObject = JSONObject.parseObject(requestData);
                    String objectData = jsonObject.getString("object");
                    String beforeJsonData =  new Base64SecurityActionImpl().unlock(objectData);
                    log.info("############ 源Object数据  #################"+beforeJsonData);
                    SysUser user = JSON.parseObject(beforeJsonData, new TypeReference<SysUser>() {});
                    log.info("############ json 字符串转javaBean  #################"+beforeJsonData);
                    log.info("############# sysUser:"+user.toString());
                    log.info("############# 服务端解析success！ ##################");
                }else{
                    log.info("############用户签名 sign 被改动 #################");
                }
            }else{
                log.info("############用户签名 sign 失效 #################");
            }
        }else{
            log.info("############用户Token 失效 #################");
        }
    }

    /**
     * 服务端通过 业务处理 返回加密数据
     */
    @Test
    public void encryptionResData() {
        log.info("########### 服务器返回数据... ###############");
        Integer id = 1;
        String sign = "19b5a7246b71a9d419179fb0dda1d2b8";
        SysUser sysUser = sysUserService.selectById(id);
        String beforeJsonString = JSON.toJSONString(sysUser);
        log.info("############服务器返回原始数据#################"+beforeJsonString);
        String encode = new Base64SecurityActionImpl().doAction(beforeJsonString);
        BaseTransferEntity baseTransferEntity = new BaseTransferEntity();
        baseTransferEntity.setObject(encode);
        baseTransferEntity.setSign(sign);
        String afterJsonString = JSON.toJSONString(baseTransferEntity);
        log.info("############服务器返回加密后数据#################"+afterJsonString);

        log.info("############# 客户端解析服务器数据 ##################");
        log.info("############ 解析数据...  #################");
        JSONObject jsonObject = JSONObject.parseObject(afterJsonString);
        String objectData = jsonObject.getString("object");
        String beforeJsonData =  new Base64SecurityActionImpl().unlock(objectData);
        log.info("############ 源Object数据  #################"+beforeJsonData);
        log.info("############# 客户端解析success！ ##################");
    }




}
