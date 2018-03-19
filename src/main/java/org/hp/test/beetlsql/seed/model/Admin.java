package org.hp.test.beetlsql.seed.model;

import org.beetl.sql.core.annotatoin.Table;

/**
 * 管理员
 *
 * @author hepan
 * @create 2018-03-18 下午10:18
 **/
@Table(name = "t_admin")
public class Admin {
    private int id;
    private String name;
    private String loggingName;
    private String passWord;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoggingName() {
        return loggingName;
    }

    public void setLoggingName(String loggingName) {
        this.loggingName = loggingName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", loggingName='" + loggingName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
