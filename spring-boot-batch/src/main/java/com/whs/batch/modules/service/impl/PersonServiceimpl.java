package com.whs.batch.modules.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.whs.batch.modules.dao.PersonMapper;
import com.whs.batch.modules.entity.Person;
import com.whs.batch.modules.service.IPersonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 21:40
 */
@Service
@Transactional(readOnly = true)
public class PersonServiceimpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

}
