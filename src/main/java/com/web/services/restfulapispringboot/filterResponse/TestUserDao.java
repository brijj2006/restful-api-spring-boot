package com.web.services.restfulapispringboot.filterResponse;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestUserDao {

    private static List<TestUser> testUsers = new ArrayList<TestUser>();

    @GetMapping(path = "/testusers")
    public MappingJacksonValue getTestUsers() {

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept("firstName", "lastName");
        FilterProvider filterProvider = new SimpleFilterProvider().addFilter("testUserFilter", simpleBeanPropertyFilter);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(testUsers);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    static {
        testUsers.add(new TestUser("Sachin", "Tendulkar", "abc"));
        testUsers.add(new TestUser("Brian", "Lara", "123"));
        testUsers.add(new TestUser("Ricky", "Ponting", "a1c"));
    }

}
