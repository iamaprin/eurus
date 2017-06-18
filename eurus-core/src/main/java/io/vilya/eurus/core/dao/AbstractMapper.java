package io.vilya.eurus.core.dao;

import java.sql.Date;

import org.jooq.DSLContext;

import io.vilya.eurus.core.manager.DBManager;
import io.vilya.eurus.core.manager.IDBManager;
import io.vilya.eurus.core.manager.Managers;

/**
 * @author iamaprin
 * @time 2017年6月11日 下午7:39:37
 */
public abstract class AbstractMapper {
            
    protected DSLContext create;
    
    AbstractMapper() {
        init();
    }
    
    private void init() {
        IDBManager dbManager = (IDBManager)Managers.INSTANCE.getInstance(DBManager.class);
        create = dbManager.getCreate();
    }
    
    protected Date now() {
        return new Date(System.currentTimeMillis());
    }
}
