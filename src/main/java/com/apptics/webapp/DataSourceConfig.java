package com.apptics.webapp;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Autowired
    private DataSource dataSource;

    @PreDestroy
    public void closeDataSource() {
        if (dataSource != null) {
            try {
                dataSource.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
