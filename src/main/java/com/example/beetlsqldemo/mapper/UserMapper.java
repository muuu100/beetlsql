package com.example.beetlsqldemo.mapper;

import com.example.beetlsqldemo.model.UserEntity;
import org.beetl.sql.mapper.BaseMapper;
import org.beetl.sql.mapper.annotation.*;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEntity> {

    @Sql("select * from sys_user where id = ?")
    @Select
    UserEntity queryUserById(Integer id);

    @Sql("update sys_user set name=? where id = ?")
    @Update
    int updateName(String name,Integer id);

    @Template("select * from sys_user where id = #{id}")
    UserEntity getUserById(Integer id);

    @SpringData
    List<UserEntity> queryByNameOrderById(String name);

    /**
     * 可以定义一个default接口
     * @return
     */
/*    default  List<DepartmentEntity> findAllDepartment(){
        Map paras = new HashMap();
        paras.put("exlcudeId",1);
        List<DepartmentEntity> list = getSQLManager().execute("select * from department where id != #{exlcudeId}",DepartmentEntity.class,paras);
        return list;
    }*/

}