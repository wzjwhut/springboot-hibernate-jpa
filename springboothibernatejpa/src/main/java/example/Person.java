package example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Data //用于自动生成getter和setter, idea需要安装插件
public class Person {
    @Id
    private long id;
    private String emailAddress;  //column名称映射规则: java使用驼峰格式, 数据库使用下划线格式， userId将映射为user_id
    private String lastname;
    private String firstname;
}