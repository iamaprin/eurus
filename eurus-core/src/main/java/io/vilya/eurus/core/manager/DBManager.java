package io.vilya.eurus.core.manager;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;

import io.vilya.eurus.core.common.annotation.Manager;
import io.vilya.eurus.core.common.constant.EurusConstants;

/**
 * @author iamaprin
 * @time 2017年6月9日 下午10:12:49
 */
@Manager
public class DBManager implements IManager, IDBManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBManager.class);
    
    private DruidDataSource dataSource;
    
    private DSLContext create;
    
    @Override
    public void startup() {
        try {
            initDataSource();
            initJOOQ();
            LOGGER.info("db inited.");
        } catch (SQLException e) {
            LOGGER.error(EurusConstants.EMPTY_STRING, e);
        }
    }

    @Override
    public void shutdown() {
        closeDataSource();
    }
    
    @Override
    public DataSource getDataSource() {
        return dataSource;
    }
    
    @Override
    public DSLContext getCreate() {
        return create;
    }
    
    /**
     * TODO configurable
     * @throws SQLException
     */
    private void initDataSource() throws SQLException {
        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/DB_VY_CORE?serverTimezone=UTC&characterEncoding=utf-8");
        dataSource.setUsername("eurus");
        dataSource.setPassword("123456");
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(5);
        dataSource.init();
    }
    
    private void initJOOQ() {
        create = DSL.using(dataSource, SQLDialect.MYSQL);
    }
    
    private void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();;
        }
    }
}
