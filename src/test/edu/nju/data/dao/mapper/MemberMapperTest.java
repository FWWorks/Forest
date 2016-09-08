package edu.nju.data.dao.mapper;

import edu.nju.data.model.Member;
import edu.nju.data.model.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by fwtgm on 2016/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)        //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})

public class MemberMapperTest {
    @Resource
    private MemberMapper mapper;
    @Resource
    private RoleMapper mapper2;

    @Test
    public void searchMember() throws Exception {
        String name="dy";
        Member m=mapper.searchMember(name);
        System.out.print(m.getRole());
    }

    @Test
    public void selectRoleById() throws Exception{
        Role r=mapper2.selectRoleById(4);
        System.out.print(r.getDescription());
    }

}