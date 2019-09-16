package com.zglu.springboot;

import com.zglu.springboot.api.TestRestController;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Log
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    TestRestController testRestController;

    @Test
    public void contextLoads() {
        log.info(testRestController.test());
    }

}
