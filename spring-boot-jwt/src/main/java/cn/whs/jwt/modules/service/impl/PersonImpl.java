package cn.whs.jwt.modules.service.impl;

import cn.whs.jwt.modules.dao.PersonMapper;
import cn.whs.jwt.modules.entity.Person;
import cn.whs.jwt.modules.service.IPersonService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 武海升
 * @version 2.0
 * @description
 * @date 2018-03-15 13:17
 */
@Service
@Transactional
public class PersonImpl extends ServiceImpl<PersonMapper, Person> implements IPersonService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public void addPerson(String name) {
        this.personMapper.insert(new Person(name));
    }

    @Override
    public void editPerson(Integer personId, String personName) {
        Wrapper<Person> wrapper = new EntityWrapper<>();
        wrapper = wrapper.eq("id", personId).and().eq("name",personName);
        this.personMapper.update(new Person(),wrapper);
    }

    @Override
    public void deletePerson(Integer personId) {
        Wrapper<Person> wrapper = new EntityWrapper<>();
        wrapper = wrapper.eq("id", personId);
        this.personMapper.delete(wrapper);
    }

    @Override
    public List<Person> selectByName(@Param("name") String name) {
        return this.baseMapper.selectByName(name);
    }
}
