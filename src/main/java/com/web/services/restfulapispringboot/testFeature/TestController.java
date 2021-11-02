package com.web.services.restfulapispringboot.testFeature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/testMessage")
    public String testMessage() {
        return "This is a test message !!!";
    }

    //implement bean
    @GetMapping(path = "/testBeanMessage")
    public TestMessageBean testBeanMessage() {
        return new TestMessageBean("This is a bean message !!!");
    }

    //path variable
    @GetMapping(path = "/testBeanMessage/name/{name}")
    public TestMessageBean testBeanPathVar(@PathVariable String name) {
        return new TestMessageBean(String.format("Hello %s, Welcome to the Java World", name));
    }

}
