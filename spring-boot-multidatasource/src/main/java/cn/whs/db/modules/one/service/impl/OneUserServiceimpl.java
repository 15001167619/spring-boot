package cn.whs.db.modules.one.service.impl;

import cn.whs.db.core.mysql.DataSourceName;
import cn.whs.db.core.mysql.annotion.DataSource;
import cn.whs.db.modules.one.dao.OneUserMapper;
import cn.whs.db.modules.one.entity.OneUser;
import cn.whs.db.modules.one.service.IOneUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:21
 */
@Service
public class OneUserServiceimpl extends ServiceImpl<OneUserMapper, OneUser> implements IOneUserService {

    @Autowired
    private OneUserMapper userMapper;

    /**
     * 新增用户
     * @param user
     */
    @DataSource(name = DataSourceName.DATA_SOURCE_BIZ_ONE)
    @Override
    public void insertOneUser(OneUser user) {
        userMapper.insert(user);
    }




}
