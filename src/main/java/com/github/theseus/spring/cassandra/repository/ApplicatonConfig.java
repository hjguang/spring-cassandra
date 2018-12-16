package com.github.theseus.spring.cassandra.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories
public class ApplicatonConfig extends AbstractCassandraConfiguration {


    /**
     * 指定Cassandra数据库
     * @return
     */
    @Override
    protected String getKeyspaceName() {
        return "cycling";
    }

    /**
     * 配置实体bean的扫描路径
     * @return
     */
    @Override
    public String[] getEntityBasePackages() {
        return new String[] { "com.github.theseus.spring.cassandra.domain" };
    }
}
