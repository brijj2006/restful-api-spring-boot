package com.web.services.restfulapispringboot.testFeature;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/testMessage")
    public String testMessage() {
        return "This is a test message !!!";
    }

    @GetMapping(path = "/testBeanMessage")
    public TestMessageBean testBeanMessage() {
        return new TestMessageBean("This is a bean message !!!");
    }

}
