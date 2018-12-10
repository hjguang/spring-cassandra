package com.theseus.github.spring.cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.theseus.github.spring.cassandra.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

import java.util.UUID;

public class CassandraMain {

    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraMain.class);

    protected static Person newPerson(String name, int age) {
        return newPerson(UUID.randomUUID().toString(), name, age);
    }

    protected static Person newPerson(String id, String name, int age) {
        return new Person(id, name, age);
    }

    public static void main(String[] args) {

        Cluster cluster = Cluster.builder().addContactPoints("localhost").build();
        Session session = cluster.connect("mykeyspace");

        CassandraOperations template = new CassandraTemplate(session);

        Person jonDoe = template.insert(newPerson("Jon Doe", 40));

        LOGGER.info(template.selectOne(Query.query(Criteria.where("id").is(jonDoe.getId())), Person.class).getId());

//        template.truncate(Person.class);
        session.close();
        cluster.close();
    }
}
