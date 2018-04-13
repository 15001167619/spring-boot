package com.whs.resttemplate;

import com.whs.resttemplate.common.BaseResponse;
import com.whs.resttemplate.modules.entity.SysUser;
import com.whs.resttemplate.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-04-13 16:23
 */
//@ActiveProfiles(profiles = "test")// 在测试类上面指定profiles
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class RestTemplateTest {

    @LocalServerPort
    private int port;
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testInsertRestTemplate() {
        SysUser sysUserParam = new SysUser(25,"小可爱");
        String addUserUrl = String.format("http://localhost:%d/user/addUser", port);
        BaseResponse baseResponse = restTemplate.postForObject(addUserUrl, sysUserParam, BaseResponse.class);
        Map data = (LinkedHashMap) baseResponse.getData();
        log.info("新增用户【年龄："+data.get("age")+"；姓名："+data.get("name")+"】");
    }
    @Test
    public void testSelectRestTemplate() {
        Integer sysUserId = 7;
        SysUser getParam = new SysUser(sysUserId);
        // 设置HTTP Header信息
        String getUserUrl = String.format("http://localhost:%d/user/getUser", port);
        URI uri;
        try {
            uri = new URI(getUserUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException("URI构建失败");
        }
        RequestEntity<SysUser> requestEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(getParam);
        ResponseEntity<BaseResponse> responseEntity = restTemplate.exchange(requestEntity, BaseResponse.class);
        BaseResponse baseResponse = responseEntity.getBody();
        Map data = (LinkedHashMap) baseResponse.getData();
        Function<Map,SysUser> sysUserFunction = (map)->{
            SysUser sysUser = null;
            try {
                sysUser = (SysUser) CommonUtils.mapToObject(map, new SysUser().getClass());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sysUser;
        };
        SysUser sysUser = sysUserFunction.apply(data);
        log.info("数据库用户"+sysUser);
        BiFunction<SysUser,Map,SysUser> sysUserFunctiona = (user,map)->new SysUser().mapToSysUser(map,user.getClass());
        SysUser apply = sysUserFunctiona.apply(new SysUser(), data);
        log.info("数据库用户"+apply);

        //Function<Map,SysUser> sysUserFunctiona = SysUser::mapToSysUser;
    }



}
