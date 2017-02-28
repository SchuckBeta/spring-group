package com.example.vaadin;

import static org.assertj.core.api.BDDAssertions.then;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Application;
import com.example.dao.TeamDao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class,
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ApplicationTests {

    @Autowired
    private TeamDao dao;

    @Test
    public void shouldFillOutComponentsWithDataWhenTheApplicationIsStarted() {
        then(this.dao.count()).isEqualTo(10);
    }

    @Test
    public void shouldFindTwoBauerCustomers() {
        then(this.dao.findByNameStartsWithIgnoreCase("Bauer")).hasSize(0);
//        then(this.dao.findByNameStartsWithIgnoreCase("Bauer")).hasSize(10);
    }
}
