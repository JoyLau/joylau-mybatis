package cn.joylau.mybatis.druid;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by LiuFa on 2017/4/5.
 * cn.joylau.mybatis.druid
 * greatapp
 */
public class FunctionDruidSource extends DruidDataSource {

    public DruidDataSource createDruidSource(@Value("${druid.url}") String url, @Value("${druid.driverClassName}")
            String driverClassName,
                                             @Value("${druid.username}") String username, @Value("${druid.password}")
                                                     String password,
                                             @Value("${druid.initialSize}") int initialSize, @Value("${druid.minIdle}")
                                                     int minIdle,
                                             @Value("${druid.maxActive}") int maxActive, @Value("${druid.maxWait}")
                                                     long maxWait,
                                             @Value("${druid.timeBetweenEvictionRunsMillis}") long
                                                     timeBetweenEvictionRunsMillis, @Value("${druid" +
            ".minEvictableIdleTimeMillis}") long
                                                     minEvictableIdleTimeMillis,
                                             @Value("${druid.validationQuery}") String validationQuery, @Value("${druid" +
            ".testWhileIdle}") boolean testWhileIdle,
                                             @Value("${druid.testOnBorrow}") boolean testOnBorrow, @Value("${druid" +
            ".testOnReturn}") boolean testOnReturn,
                                             @Value("${druid.poolPreparedStatements}") boolean poolPreparedStatements,
                                             @Value("${druid.filters}") String filters,
                                             @Value("${druid.stat.mergeSql}") String mergeSql, @Value("${druid.stat" +
            ".slowSqlMillis}") String slowSqlMillis,
                                             @Value("${druid.useGlobalDataSourceStat}") boolean
                                                     useGlobalDataSourceStat) throws SQLException {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setFilters(filters);
        Properties properties = new Properties();
        properties.setProperty("druid.stat.mergeSql", mergeSql);
        properties.setProperty("druid.stat.slowSqlMillis", slowSqlMillis);
        dataSource.setConnectProperties(properties);
        dataSource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
        return dataSource;
    }
}
