package io.vilya.eurus.core.dao;

import java.util.List;

import org.jooq.InsertSetStep;
import org.jooq.UpdateSetMoreStep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.entity.tables.Account;
import io.vilya.eurus.core.entity.tables.records.AccountRecord;

/**
 * 账号信息
 * @author iamaprin
 * @time 2017年6月11日 下午8:09:41
 */
public class AccountMapper extends AbstractMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountMapper.class);
    
    public int save(AccountRecord record) {
        
        InsertSetStep<AccountRecord> executer = create
                .insertInto(Account.ACCOUNT);
        
        if (record.getAccUsername() != null) {
            executer.set(Account.ACCOUNT.ACC_USERNAME, record.getAccUsername());
        }
        
        if (record.getAccPassword() != null) {
            executer.set(Account.ACCOUNT.ACC_PASSWORD, record.getToken());
        }
        
        if (record.getToken() != null) {
            executer.set(Account.ACCOUNT.TOKEN, record.getToken());
        }
        
        return executer
                .set(Account.ACCOUNT.CREATE_TIME, now())
                .set(Account.ACCOUNT.UPDATE_TIME, now())
                .set(Account.ACCOUNT.IS_DELETED, false)
                .execute();
    }
    
    public int remove(int id) {
        return create
                .deleteFrom(Account.ACCOUNT)
                .where(Account.ACCOUNT.ID.eq(id))
                .execute();
    }
    
    public int update(AccountRecord record) {
        if (record.getId() == null) {
            return -1;
        }
        
        UpdateSetMoreStep<AccountRecord> executer = create.update(Account.ACCOUNT)
                .set(Account.ACCOUNT.ID, record.getId());
        
        if (record.getAccUsername() != null) {
            executer.set(Account.ACCOUNT.ACC_USERNAME, record.getAccUsername());
        }
        
        if (record.getAccPassword() != null) {
            executer.set(Account.ACCOUNT.ACC_PASSWORD, record.getAccPassword());
        }
        
        if (record.getToken() != null) {
            executer.set(Account.ACCOUNT.TOKEN, record.getToken());
        }
        
        if (record.getIsDeleted() != null) {
            executer.set(Account.ACCOUNT.IS_DELETED, record.getIsDeleted());
        }
        
        executer.set(Account.ACCOUNT.UPDATE_TIME, now());
        
        return executer
                .where(Account.ACCOUNT.ID.eq(record.getId()))
                .execute();
    }

    public List<AccountRecord> list() {
        return create
                .selectFrom(Account.ACCOUNT)
                .where(Account.ACCOUNT.IS_DELETED.eq(false))
                .fetch();
    }

    public AccountRecord get(int id) {
        return create
                .selectFrom(Account.ACCOUNT)
                .where(Account.ACCOUNT.ID.eq(id))
                .and(Account.ACCOUNT.IS_DELETED.eq(false))
                .fetchOne();
    }
    

 
}
