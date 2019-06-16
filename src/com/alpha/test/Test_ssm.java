package com.alpha.test;


import com.alpha.mapper.CategoryMapper;
import com.alpha.mapper.ProductMapper;
import com.alpha.pojo.Category;
import com.alpha.pojo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test_ssm {
//    @Autowired
//    private ProductMapper productMapper;
//
//    @Test
//    public void productAdd(){
//        for (int i=0;i<100;i++){
//            Product product=new Product();
//            product.setName("product "+i);
//            product.setPrice(i);
//            productMapper.add(product);
//        }
//    }
    //还没有提供add 方法;


//
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testAdd(){
        for (int i=0;i<100;i++){
            Category category=new Category();
            category.setName("new Category");
            categoryMapper.add(category);

        }
    }
//
//    @Test
//    public void testTotal(){
//        int total=categoryMapper.total();
//        System.out.println(total);
//    }
//
//    @Test
//    public void testList(){
//        Page p=new Page();
//        p.setStart(2);
//        p.setCount(3);
//        List<Category> cs=categoryMapper.list(p);
//        cs.forEach(c->{
//            System.out.println(c.getName());
//        });
//    }
}
