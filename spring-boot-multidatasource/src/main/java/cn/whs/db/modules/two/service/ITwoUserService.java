package cn.whs.db.modules.two.service;

import cn.whs.db.modules.two.entity.TwoUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:05
 */
public interface ITwoUserService  extends IService<TwoUser> {
    void insertTwoUser(TwoUser twoUser);
}
