package com.theseus.github.spring.cassandra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CustmizeConfig extends AbstractCassandraConfiguration {

    protected String getKeyspaceName() {
        return null;
    }
}
