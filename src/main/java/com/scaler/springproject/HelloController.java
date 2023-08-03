package com.scaler.springproject;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {
    List<String> s=new ArrayList<String>();
    @GetMapping("/hello/{id}")
    public String hello(@PathVariable String id){
        if(s.size()>0 && s.size()>Integer.parseInt(id))
            return "hello "+s.get(Integer.parseInt(id));
        return "no greetings with given id";
    }

    @PostMapping("/greeting")
    public void greeting(@RequestParam String greetings){
        s.add(greetings);
        System.out.println("Greetings received : "+greetings);
    }
}
