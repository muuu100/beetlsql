package com.example.beetlsqldemo.model;

import lombok.Data;
import org.beetl.sql.annotation.entity.Table;

import java.sql.Timestamp;
import java.util.Date;

@Table(name="gap_user")
@Data
public class Employee {
	Integer id;
	String code;
	String name;
}
