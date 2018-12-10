package com.github.theseus.spring.cassandra;

import com.datastax.driver.core.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

@Configuration
@ComponentScan(basePackages = "com.github.theseus.spring.cassandra.config")
public class SpringaAnnotationMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringaAnnotationMain.class);
        Session session = context.getBean(Session.class);
        CassandraOperations template = new CassandraTemplate(session);
    }
}
