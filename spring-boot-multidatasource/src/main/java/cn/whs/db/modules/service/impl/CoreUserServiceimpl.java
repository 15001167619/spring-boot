package cn.whs.db.modules.service.impl;

import cn.whs.db.core.mysql.DataSourceName;
import cn.whs.db.core.mysql.annotion.DataSource;
import cn.whs.db.modules.dao.CoreUserMapper;
import cn.whs.db.modules.entity.CoreUser;
import cn.whs.db.modules.service.ICoreUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:22
 */
@Service
public class CoreUserServiceimpl extends ServiceImpl<CoreUserMapper, CoreUser> implements ICoreUserService {

    @Autowired
    private CoreUserMapper coreUserMapper;

    @Override
    @DataSource(name = DataSourceName.DATA_SOURCE_BIZ_ONE)
    public void insertOneUser(CoreUser coreUser) {
        coreUserMapper.insert(coreUser);
    }

    @DataSource(name = DataSourceName.DATA_SOURCE_BIZ_TWO)
    @Override
    public void insertTwoUser(CoreUser coreUser) {
        coreUserMapper.insert(coreUser);
    }
}
