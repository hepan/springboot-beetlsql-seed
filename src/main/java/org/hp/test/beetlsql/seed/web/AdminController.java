package org.hp.test.beetlsql.seed.web;

import org.beetl.sql.core.engine.PageQuery;
import org.hp.test.beetlsql.seed.model.Admin;
import org.hp.test.beetlsql.seed.service.AdminServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author hepan
 * @create 2018-03-18 下午10:24
 **/
@RequestMapping("/admins")
@Controller
public class AdminController {

    @Autowired
    private AdminServiceInterface adminService;


    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Admin> listAll() {
        return adminService.findAll();
    }

    @RequestMapping(value = "page/{page}/size/{size}",method = RequestMethod.GET)
    public @ResponseBody PageQuery<Admin> listAll(@PathVariable long page, @PathVariable long size) {
        return adminService.pageQuery(page,size);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    private @ResponseBody Admin detail(@PathVariable Integer id){
        return adminService.findById(id);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ModelAndView test(@ModelAttribute Admin admin){
        System.out.println(admin.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message","测试");
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
