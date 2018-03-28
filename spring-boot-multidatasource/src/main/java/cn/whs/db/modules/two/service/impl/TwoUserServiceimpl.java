package cn.whs.db.modules.two.service.impl;

import cn.whs.db.modules.two.dao.TwoUserMapper;
import cn.whs.db.modules.two.entity.TwoUser;
import cn.whs.db.modules.two.service.ITwoUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:07
 */
@Service
public class TwoUserServiceimpl extends ServiceImpl<TwoUserMapper, TwoUser> implements ITwoUserService {
}
