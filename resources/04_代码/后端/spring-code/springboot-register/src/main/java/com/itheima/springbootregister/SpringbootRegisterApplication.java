package com.itheima.springbootregister;

import cn.itcast.pojo.Country;
import com.itheima.anno.EnableCommonConfig;
import com.itheima.config.CommonConfig;
import com.itheima.config.CommonImportSelector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@Import({CommonConfig.class})
//@Import(CommonImportSelector.class)
@EnableCommonConfig
public class SpringbootRegisterApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootRegisterApplication.class, args);

        //Country country = context.getBean(Country.class);
        //System.out.println(country);

        System.out.println(context.getBean("province"));
    }

}
