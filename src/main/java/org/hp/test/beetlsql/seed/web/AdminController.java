package org.hp.test.beetlsql.seed.web;

import org.beetl.sql.core.engine.PageQuery;
import org.hp.test.beetlsql.seed.dao.AdminDao;
import org.hp.test.beetlsql.seed.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hepan
 * @create 2018-03-18 下午10:24
 **/
@RequestMapping("/admins")
@RestController
public class AdminController {

    @Autowired
    private AdminDao adminDao;


    @RequestMapping(method = RequestMethod.GET)
    public List<Admin> listAll() {
        return adminDao.all();
    }

    @RequestMapping(value = "page/{page}/size/{size}",method = RequestMethod.GET)
    public PageQuery<Admin> listAll(@PathVariable long page, @PathVariable long size) {
        PageQuery<Admin> pq=new PageQuery(page,size);
        return adminDao.getSQLManager().pageQuery("admin.queryPageAdmin",Admin.class,pq);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    private Admin detail(@PathVariable Integer id){
        return adminDao.single(id);
    }
}
