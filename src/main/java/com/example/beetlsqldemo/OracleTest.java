package com.example.beetlsqldemo;

import com.example.beetlsqldemo.model.UserEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.OracleStyle;
import org.beetl.sql.ext.DebugInterceptor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleTest {

    public static void main(String[] args){
        DataSource dataSource = datasource();
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        builder.setNc(new UnderlinedNameConversion());
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        builder.setDbStyle(new OracleStyle());
        SQLManager sqlManager = builder.build();

		/*long time = System.currentTimeMillis();
		Date start = new Date(time-100);
		Date end = new Date(time+100);
		long count = sqlManager.lambdaQuery(Employee.class).andBetween(Employee::getHireDate,start,end).count();*/

        /*long count = sqlManager.lambdaQuery(Employee.class).andBetween(Employee::getId,1,10).count();
        System.out.println(count+"...............");*/

/*
        UserEntity user  = sqlManager.unique(UserEntity.class,1);
*/

/*        UserEntity user  = sqlManager.unique(UserEntity.class,1);
        user.setName("ok123");
        sqlManager.updateById(user);*/

/*        UserEntity template = new UserEntity();
        template.setDepartmentId(1);
        List<UserEntity> list = sqlManager.template(template);*/

/*        String sql = "select * from sys_user where id=?";
        Integer id  = 1;
        SQLReady sqlReady = new SQLReady(sql,new Object[]{id});
        List<UserEntity> userEntities = sqlManager.execute(sqlReady,UserEntity.class);

        String updateSql = "update sys_user set name=? where id =?";
        String name="lijz";
        SQLReady updateSqlReady = new SQLReady(updateSql,new Object[]{name,id});
        sqlManager.executeUpdate(updateSqlReady);*/

/*        String sql = "select * from sys_user where department_id=#{departmentId} and name=#{name}";
        UserEntity paras = new UserEntity();
        paras.setDepartmentId(1);
        paras.setName("lijz");
        List<UserEntity> list = sqlManager.execute(sql,UserEntity.class,paras);*/

        //或者使用Map作为参数
/*        String sql = "select * from sys_user where department_id=${myDeptId} and name=${myName}";
        Map paras = new HashMap();
        paras.put("myDeptId",1);
        paras.put("myName","'lijz'");
        List<UserEntity> list = sqlManager.execute(sql,UserEntity.class,paras);*/

        /*String sql = "select * from sys_user where 1=1 \n" +
                "-- @if(isNotEmpty(myDeptId)){\n" +
                "   and department_id=#{myDeptId}\n" +
                "-- @}\n" +
                "and name=#{myName}";

        Map paras = new HashMap();
        paras.put("myDeptId",1);
        paras.put("myName","lijz");
        List<UserEntity> list = sqlManager.execute(sql,UserEntity.class,paras);*/

/*        LambdaQuery<UserEntity> query = sqlManager.lambdaQuery(UserEntity.class);
        List<UserEntity> entities = query.andEq(UserEntity::getDepartmentId,1)
                .andIsNotNull(UserEntity::getName).select();*/

/*        UserMapper mapper = sqlManager.getMapper(UserMapper.class);
        UserEntity me = mapper.unique(1);//同SQLManager.unique(UserEntity.class,1)
        me.setName("newName");
        mapper.updateById(me);//同SQLManager.updateById(me);*/

        SqlId id = SqlId.of("user","select");
        Map map = new HashMap();
//        map.put("name","n");
        List<UserEntity> list = sqlManager.select(id,UserEntity.class,map);
    }

    public static DataSource datasource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:orcl");
        ds.setUsername("PB211L");
        ds.setPassword("1");
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        return ds;
    }
}
