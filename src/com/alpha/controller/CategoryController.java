package com.alpha.controller;

import com.alibaba.fastjson.JSONObject;
import com.alpha.pojo.Category;
import com.alpha.service.CategoryService;
import com.alpha.util.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
//    是不是高版本的spring 没有ModelAndView

    @RequestMapping(value = "/categories",method = RequestMethod.GET)
    public ModelAndView listCategory(Page page){
        ModelAndView mav=new ModelAndView();
//        List<Category> cs=categoryService.list(page);
//        int total=categoryService.total();
        PageHelper.offsetPage(page.getStart(),5);
        List<Category> cs=categoryService.list();
        int total= (int) new PageInfo<>(cs).getTotal();
        page.calculateLast(total);

        mav.addObject("cs",cs);
        mav.setViewName("listCategory");
        return mav;

    }

    @RequestMapping(value = "/categories",method = RequestMethod.POST)
    public ModelAndView addCategory(Category category){
        System.out.println();
        categoryService.add(category);
        ModelAndView mav=new ModelAndView("redirect:/categories");
        return mav;
    }
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.DELETE)
    public ModelAndView deleteCategory(Category category){
        categoryService.delete(category);
        ModelAndView mav=new ModelAndView("redirect:/categories");
        return mav;
    }
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.GET)
    public ModelAndView editCategory(Category category){
        Category c=categoryService.get(category.getId());
        ModelAndView mav=new ModelAndView("editCategory");
        mav.addObject("c",c);
        return mav;
    }
    @RequestMapping(value = "/categories/{id}",method = RequestMethod.PUT)
    public ModelAndView updateCategory(Category category){
        categoryService.update(category);
        ModelAndView mav=new ModelAndView("redirect:/categories");
        return mav;
    }


    @ResponseBody
    @RequestMapping("/submitCategory")
    public String submitCategory(@RequestBody Category category){
        System.out.println("SSM 接受浏览器提交的JSON,转化为Category对象:"+category);
        JSONObject result=new JSONObject();
        result.put("alpha","ok");
        return  result.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/getOneCategory")
    public String getOneCategory(){
        Category c=new Category();
        c.setName("100th category");
        c.setId(100);
        JSONObject json=new JSONObject();
        json.put("category",JSONObject.toJSON(c));
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("getManyCategory")
    public String getManyCategory(){
        List<Category> cs=new ArrayList<>();

        for (int i=0;i<10;i++){
            Category c=new Category();
            c.setId(i);
            c.setName("分类名称:"+i);
            cs.add(c);
        }
        return JSONObject.toJSON(cs).toString();
    }
}
