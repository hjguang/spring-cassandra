package com.github.theseus.test;

import com.github.theseus.spring.cassandra.domain.Person;
import com.github.theseus.spring.cassandra.reposity.AppConfig;
import com.github.theseus.spring.cassandra.reposity.PersonReposity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ComponentScan(basePackages = "com.github.theseus.spring.cassandra.reposity")
@ContextConfiguration
@ComponentScan("com.github.theseus.spring.cassandra.reposity")
public class ReposityTest {

    @Autowired
    PersonReposity personReposity;

    @Test
    public void testReadAll() {
        Iterable<Person> personpIterable = personReposity.findAll();
        personpIterable.forEach(p -> System.out.println(p.toString()));
    }
}
