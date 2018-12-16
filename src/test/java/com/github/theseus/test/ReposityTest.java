package com.github.theseus.test;

import com.github.theseus.spring.cassandra.domain.Person;
import com.github.theseus.spring.cassandra.repository.ApplicatonConfig;
import com.github.theseus.spring.cassandra.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicatonConfig.class)
public class ReposityTest {

    @Autowired
    PersonRepository repository;

    @Test
    public void testReadAll() {
        Iterable<Person> personpIterable = repository.findAll();
        personpIterable.forEach(p -> System.out.println(p.toString()));
    }

    @Test
    public void testCreate() {
        Person p = new Person(UUID.randomUUID().toString(), "theseus", 21);
        repository.save(p);
    }

    @Test
    public void testUpdate() {
        Person p = new Person("5931583b-39b2-48ac-ba5d-e7b63523a97f", "Jon Doe", 40);
        repository.save(p);
    }

    @Test
    public void testBatchCreate() {
        List<Person> personList = new ArrayList<>();
        for (int i=0;i<10;i++) {
            personList.add(new Person(UUID.randomUUID().toString(), "测试" + i, 50 + i));
        }
        repository.saveAll(personList);
    }

    /**
     * 创建SASIIndex索引，以支持模糊查询
     */
    @Test
    public void testFind() {
        List<Person> personList = repository.findByNameLike("测试%");
        personList.stream().forEach(p -> System.out.println(p.toString()));
    }

}
