package org.killer.shardingjdbcdemo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.shardingsphere.api.config.masterslave.MasterSlaveRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.ShardingRuleConfiguration;
import org.apache.shardingsphere.api.config.sharding.TableRuleConfiguration;
import org.apache.shardingsphere.shardingjdbc.api.MasterSlaveDataSourceFactory;
import org.apache.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

/**
 * @author killer
 * @date 2020/05/04 - 16:22
 */
@Configuration
public class DatasourceConfig {

    /** 读写分离配置 */
    // @Bean
    public DataSource getDatasources() throws SQLException {
        HashMap<String, DataSource> dataSources = new HashMap<>(2);

        HikariDataSource hikariWriteDataSource = new HikariDataSource();
        hikariWriteDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariWriteDataSource.setJdbcUrl("jdbc:mysql://47.107.106.214:3306/sharding-jdbc-demo");
        hikariWriteDataSource.setUsername("root");
        hikariWriteDataSource.setPassword("wqsqzj");

        HikariDataSource hikariReadDataSource = new HikariDataSource();
        hikariReadDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariReadDataSource.setJdbcUrl("jdbc:mysql://139.9.81.141:3306/sharding-jdbc-demo");
        hikariReadDataSource.setUsername("root");
        hikariReadDataSource.setPassword("wqsqzj");

        dataSources.put("master", hikariWriteDataSource);
        dataSources.put("slave", hikariReadDataSource);

        // 配置读写分离, 这个玩意儿的配置粒度应该是表级别的
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("ds_master_slave1", "master", Arrays.asList("slave"));

        // properties 代表的是有getter/setter方法的属性
        Properties properties = new Properties();
        properties.setProperty("sql.show", "true"); // 打印sql语句
        return MasterSlaveDataSourceFactory.createDataSource(dataSources, masterSlaveRuleConfig, properties);

    }

    /** 数据分片配置 */
    @Bean
    public DataSource getShardingDataSource() throws SQLException {

        HashMap<String, DataSource> dataSources = new HashMap<>(2);

        HikariDataSource hikariWriteDataSource = new HikariDataSource();
        hikariWriteDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariWriteDataSource.setJdbcUrl("jdbc:mysql://47.107.106.214:3306/sharding-jdbc-demo");
        hikariWriteDataSource.setUsername("root");
        hikariWriteDataSource.setPassword("wqsqzj");

        HikariDataSource hikariWriteShardingDataSource = new HikariDataSource();
        hikariWriteShardingDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariWriteShardingDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/sharding-jdbc-demo?serverTimezone=Asia/Shanghai");
        hikariWriteShardingDataSource.setUsername("root");
        hikariWriteShardingDataSource.setPassword("wqsqzj");

        dataSources.put("ds0", hikariWriteDataSource);
        dataSources.put("ds1", hikariWriteShardingDataSource);

        // 配置user表策略， 同一个库中没有分表, 为什么join出来的没有呢？？ 还没有使用分片策略
        TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration("users", "ds${0..1}.users");

        ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
        shardingRuleConfiguration.setTableRuleConfigs(Collections.singletonList(tableRuleConfiguration));

        return ShardingDataSourceFactory.createDataSource(dataSources, shardingRuleConfiguration, new Properties());

    }

}
