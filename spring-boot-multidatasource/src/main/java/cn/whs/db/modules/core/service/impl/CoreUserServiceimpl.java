package cn.whs.db.modules.core.service.impl;

import cn.whs.db.modules.core.dao.CoreUserMapper;
import cn.whs.db.modules.core.entity.CoreUser;
import cn.whs.db.modules.core.service.ICoreUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:22
 */
@Service
public class CoreUserServiceimpl extends ServiceImpl<CoreUserMapper, CoreUser> implements ICoreUserService {
}
