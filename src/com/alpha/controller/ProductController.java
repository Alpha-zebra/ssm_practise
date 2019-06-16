package com.alpha.controller;

import com.alpha.pojo.Product;
import com.alpha.service.ProductService;
import com.alpha.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    @Autowired
    ProductService productService;

    @RequestMapping("listProduct")
    public ModelAndView listProduct(Page page){

        ModelAndView mav=new ModelAndView();

        PageHelper.offsetPage(page.getStart(),5);

        List<Product> ps=productService.list();

        int total= (int) new PageInfo<>(ps).getTotal();
        page.calculateLast(total);

        mav.addObject("ps",ps);
        mav.setViewName("listProduct");
        return mav;
    }
//    @RequestMapping("listProduct")
//    public ModelAndView listProduct(){
//
//        ModelAndView mav=new ModelAndView();
//        List<Product> ps=productService.list();
//
//        mav.addObject("ps",ps);
//        mav.setViewName("listProduct");
//        return mav;
//    }

    @RequestMapping("addProduct")
    public ModelAndView addProduct(Product product){
        productService.add(product);
        ModelAndView mav=new ModelAndView("redirect:/listProduct");
        return mav;
    }

    @RequestMapping("deleteProduct")
    public ModelAndView deleteProduct(int id){
        productService.delete(id);
        ModelAndView mav=new ModelAndView("redirect:/listProduct");
        return mav;
    }

    @RequestMapping("editProduct")
    public ModelAndView editProduct(int id){
        Product p=productService.get(id);
        ModelAndView mav=new ModelAndView();
        mav.addObject("p",p);
        mav.setViewName("editProduct");
        return mav;
    }

    @RequestMapping("updateProduct")
    public ModelAndView update(Product product){
        productService.update(product);
        ModelAndView mav=new ModelAndView("redirect:/listProduct");
        return mav;
    }

}
