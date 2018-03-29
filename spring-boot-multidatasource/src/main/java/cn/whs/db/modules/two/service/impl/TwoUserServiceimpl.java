package cn.whs.db.modules.two.service.impl;

import cn.whs.db.core.mysql.DataSourceName;
import cn.whs.db.core.mysql.annotion.DataSource;
import cn.whs.db.modules.two.dao.TwoUserMapper;
import cn.whs.db.modules.two.entity.TwoUser;
import cn.whs.db.modules.two.service.ITwoUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:07
 */
@Service
public class TwoUserServiceimpl extends ServiceImpl<TwoUserMapper, TwoUser> implements ITwoUserService {

    @Autowired
    private TwoUserMapper userMapper;

    /**
     * 新增用户
     * @param user
     */
    @DataSource(name = DataSourceName.DATA_SOURCE_BIZ_TWO)
    @Override
    public void insertTwoUser(TwoUser twoUser) {
        userMapper.insert(twoUser);
    }
}
