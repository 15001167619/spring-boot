package cn.whs.db.modules.one.service;

import cn.whs.db.modules.one.entity.OneUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:03
 */
public interface IOneUserService  extends IService<OneUser> {

   void insertOneUser(OneUser user);

}
