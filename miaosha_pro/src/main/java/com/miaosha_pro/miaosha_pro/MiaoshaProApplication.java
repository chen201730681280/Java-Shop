package com.miaosha_pro.miaosha_pro;

import com.miaosha_pro.miaosha_pro.dao.UserDOMapper;
import com.miaosha_pro.miaosha_pro.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.miaosha_pro.miaosha_pro"})
@RestController

/*把dao存放的地方设置在对应的注解下*/
@MapperScan("com.miaosha_pro.miaosha_pro.dao")
public class MiaoshaProApplication {

    /**
     * @Autowired 可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作
     * 通过@Autowired的使用来消除set和ger方法（也就是自动get和set）
     */
    @Autowired
    private UserDOMapper userDOMapper;




    /**
     * @RequestMapping 用于处理请求地址映射的注解
     * -- 类： 表示类中的所有响应请求的方法都是以该地址作为父路径
     * ----method是定义接收浏览器发来的什么请求
     * ----RequestMethod来定义浏览器请求的方式
     * ----params请求参数
     * ----headers可以限制客户端发来的请求
     * -- 方法: 相对于类上的路径
     * @return
     */
    @RequestMapping("/")
    public String home(){
        UserDO userDO=userDOMapper.selectByPrimaryKey(1);
        if(userDO==null){
            return "用户对象不存在";
        }else{
            return userDO.getName();
        }

    }
    public static void main(String[] args) {
        System.out.println("hello");
        SpringApplication.run(MiaoshaProApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
}
