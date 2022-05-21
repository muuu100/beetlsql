package com.example.beetlsqldemo;

import com.example.beetlsqldemo.mapper.UserMapper;
import com.example.beetlsqldemo.model.UserEntity;
import com.zaxxer.hikari.HikariDataSource;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.OracleStyle;
import org.beetl.sql.ext.DebugInterceptor;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OracleInsertTest {

    public static void main(String[] args){
        DataSource dataSource = datasource();
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        builder.setNc(new UnderlinedNameConversion());
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        builder.setDbStyle(new OracleStyle());
        SQLManager sqlManager = builder.build();


        UserEntity user = new UserEntity();
//        user.setId(12);
        user.setDepartmentId(1);
        user.setName("xiandafu");
        sqlManager.insert(user);
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
