package edu.nju.data.dao.mapper;

import edu.nju.data.model.GraduateRecord;
import edu.nju.data.model.Role;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> showAll();

    Role selectRoleByName(String name);

    List<GraduateRecord> getGraduateRecordOfGoal(String roleName);

    int addGraduateRecordOfGoal(GraduateRecord record);
}