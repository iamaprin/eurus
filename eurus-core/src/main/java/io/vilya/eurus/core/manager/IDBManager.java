package io.vilya.eurus.core.manager;

import javax.sql.DataSource;

import org.jooq.DSLContext;

/**
 * @author iamaprin
 * @time 2017年6月11日 下午8:03:53
 */
public interface IDBManager {

    DataSource getDataSource();

    DSLContext getCreate();

}