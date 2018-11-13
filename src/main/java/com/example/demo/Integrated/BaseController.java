package com.example.demo.Integrated;


import com.example.demo.Mongo.entity.AutoIdTets;
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
    @Autowired
    private AutoIdTets autoIdTets;

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



    @RequestMapping("/save")
    @ResponseBody
    public void  save(){

        People people=new People();
        people.setName("Albert");
        people.setAge(19);
        Long logtemp = autoIdTets.getNextId("peopleId");
        int returnId = Long.valueOf(logtemp).intValue();
        people.setId(returnId);
        baseService.save(people);
    }


    @RequestMapping("/update")
    @ResponseBody
    public void update( ){

        People people=new People();

        Long logtemp = autoIdTets.getNextId("peopleId");

        people.setName("Back");
        people.setAge(15);
        baseService.update(people);
    };


    @RequestMapping("/upsert")
    @ResponseBody
    public void upsert( ){

        People people=new People();

        people.setName("Ablert");
        people.setAge(16);
        baseService.upsert(people);
    };

}
