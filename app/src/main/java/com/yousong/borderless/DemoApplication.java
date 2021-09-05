package com.yousong.borderless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RequestMapping("/api/v1")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping(value="/helloWorld")
    @CrossOrigin(origins = "http://localhost:3000/api/v1")
    public String helloWorld() {
        System.out.println("okk");
        return "Hello World!";
    }

    @GetMapping("/view/ssr")
    public ArrayList<HashMap<String, Object>> listUserswithProxy() {

        String name = "yousong";
        ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i< 1000; i++) {
            HashMap<String, Object> user = new HashMap<>();
            user.put("id", i);
            user.put("name", name+'"'+i+'"');
            userList.add(user);
        }
        return userList;

    }

    @GetMapping("/view/csr")
    public ArrayList<HashMap<String, Object>> listUserswithoutProxy() {

        String name = "daeyoung";
        ArrayList<HashMap<String, Object>> userList = new ArrayList<HashMap<String, Object>>();
        for(int i=0; i< 1000; i++) {
            HashMap<String, Object> user = new HashMap<>();
            user.put("id", i);
            user.put("name", name+'"'+i+'"');
            userList.add(user);
        }
        return userList;

    }

}
