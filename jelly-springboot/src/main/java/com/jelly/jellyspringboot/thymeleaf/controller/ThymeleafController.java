package com.jelly.jellyspringboot.thymeleaf.controller;

import com.jelly.jellyspringboot.thymeleaf.entity.Product;
import com.jelly.jellyspringboot.thymeleaf.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    ProductService productService=new ProductService();
    @GetMapping("/index")
    public  String index(Map<String,Object> map){
        map.put("hello","List");
        List<Product> productList=  productService.findAll();
        map.put("product",productList);

        return "/thymeleaf/index";
    }
    @GetMapping("/index/{id}")
    public  String index(@PathVariable(name = "id") int id, Map<String,Object> map){
        Product product=productService.findById(id);
        map.put("hello","Detail");
        map.put("prod",product);
        return "/thymeleaf/index";
    }
}
