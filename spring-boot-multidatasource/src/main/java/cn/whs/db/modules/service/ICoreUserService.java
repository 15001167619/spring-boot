package cn.whs.db.modules.service;


import cn.whs.db.modules.entity.CoreUser;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-28 16:04
 */
public interface ICoreUserService  extends IService<CoreUser> {

    void insertOneUser(CoreUser coreUser);
    void insertTwoUser(CoreUser coreUser);

}
