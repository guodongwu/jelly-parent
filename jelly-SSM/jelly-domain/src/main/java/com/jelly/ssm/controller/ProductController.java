package com.jelly.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 产品管理
 */
@Controller
public class ProductController {

    /**
     * 产品列表
     * @return
     */
    @GetMapping("/product-list")
    public  String  productlist(){
        return "product-list";
    }


    @GetMapping("/product-add")
    public  String productadd(){
        return  "product-add";
    }
    /**
     * 品牌管理
     * @return
     */
    @GetMapping("/product-brand")
    public  String productbrand(){
        return  "product-brand";
    }
    @GetMapping("/product-show")
    public  String productshow(){
        return  "product-show";
    }
    @GetMapping("/product-category")
    public  String productcategory(){
        return  "product-category";
    }
    @GetMapping("/product-category-add")
    public  String productcategoryadd(){
        return  "product-category-add";
    }

}
