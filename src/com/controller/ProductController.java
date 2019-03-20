package com.controller;

import com.entity.ProductEntity;
import com.entity.ProductTypeEntity;
import com.service.ProducTypetServiceImpl;
import com.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2019/3/15.
 */
@Controller
@RequestMapping("pro")
public class ProductController {
    @Resource
    ProductServiceImpl ser;

    @Resource
    ProducTypetServiceImpl typeser;
    //处理查询所有请求的方法
    @RequestMapping("/findAll")
    public  String findAllProduct(Model model){
        //调用查询所有方法
        List<ProductEntity> prolist = ser.findAll();
        //将集合封装到model返回给页面
        model.addAttribute("prolist",prolist);
        return "index";
    }
    @RequestMapping("/insert")
    public  String add(Model model,ProductEntity pro){
            ser.addPro(pro);
        return "redirect:/findAll.do";
    }
    @RequestMapping("/addpro1")
    public String add1(Model model){
        List<ProductTypeEntity> all = typeser.findAll();
        model.addAttribute("all",all);
        model.addAttribute("productEntity",new ProductEntity());
        return "add";
    }

    @RequestMapping("/addpro2")
    public String add2(ProductEntity pro){
        ser.addPro(pro);
        System.out.println(pro);
        return "redirect:/pro/findAll.do";
    }

    @RequestMapping("/deletepro")
    public String delete(int id){
        ser.deletePro(id);
        return "redirect:/pro/findAll.do";
    }

    @RequestMapping("/updatepro1")
    public String update1(int id,Model model){
        ProductEntity pro = ser.findById(id);
        List<ProductTypeEntity> all = typeser.findAll();
        model.addAttribute("pro",pro);
        model.addAttribute("all",all);
        return "update";
    }
    @RequestMapping("/updatepro2")
    public String update2(ProductEntity pro){
        System.out.println(pro.getId());
        System.out.println(pro.getName());
        System.out.println(pro.getPrice());
        System.out.println(pro.getProductType().getId());
            ser.updatePro(pro);

        return "redirect:/pro/findAll.do";
    }
}
