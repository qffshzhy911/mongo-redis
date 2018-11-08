package com.example.demo.Integrated;


import com.example.demo.Mongo.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @RequestMapping("/all")
    @ResponseBody
    public List<People> findAll(String name){

        return baseService.findAll();
    }



    @RequestMapping("/findone/{name}")
    @ResponseBody
    public People findOne( @PathVariable String name){

        return baseService.findone(name);
    }


}
