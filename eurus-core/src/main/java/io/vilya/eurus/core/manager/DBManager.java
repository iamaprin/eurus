package io.vilya.eurus.core.manager;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.lang3.StringUtils;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.ConnectionSource;
import org.beetl.sql.core.ConnectionSourceHelper;
import org.beetl.sql.core.SQLLoader;
import org.beetl.sql.core.SQLManager;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;

import io.vilya.eurus.core.annotation.Manager;

/**
 * @author iamaprin
 * @time 2017年6月9日 下午10:12:49
 */
@Manager
public class DBManager implements IManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBManager.class);
    
    private DruidDataSource dataSource;
    
    private SQLManager sqlManager;
    
    @Override
    public void startup() {
        try {
            initDataSource();
            initBeetlSQL();
            LOGGER.info("db inited.");
        } catch (SQLException e) {
            LOGGER.error(StringUtils.EMPTY, e);
        }
    }

    @Override
    public void shutdown() {
        closeDataSource();
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    public SQLManager getSQLManager() {
        return sqlManager;
    }
    
    /**
     * TODO configurable
     * @throws SQLException
     */
    private void initDataSource() throws SQLException {
        dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/DB_VY_CORE?serverTimezone=UTC&characterEncoding=utf-8");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setMinIdle(1);
        dataSource.setMaxActive(5);
        dataSource.init();
    }
    
    private void initBeetlSQL() {
        ConnectionSource source = ConnectionSourceHelper.getSingle(dataSource);
        DBStyle style = new MySqlStyle();
        SQLLoader loader = new ClasspathLoader("/sql");
        sqlManager = new SQLManager(style, loader, source);
    }
    
    private void closeDataSource() {
        if (dataSource != null) {
            dataSource.close();;
        }
    }
}
