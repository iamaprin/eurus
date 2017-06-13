package io.vilya.eurus.core.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.entity.tables.Account;
import io.vilya.eurus.core.entity.tables.Member;
import io.vilya.eurus.core.entity.tables.records.AccountRecord;

/**
 * 账号信息
 * @author iamaprin
 * @time 2017年6月11日 下午8:09:41
 */
public class AccountMapper extends AbstractMapper {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountMapper.class);
    
    public int save(AccountRecord record) {
        return create
                .insertInto(Account.ACCOUNT)
                .set(record)
                .execute();
    }
    
    public int remove(int id) {
        return create
                .deleteFrom(Account.ACCOUNT)
                .where(Account.ACCOUNT.ID.eq(id))
                .execute();
    }
    
    public int update(AccountRecord record) {
        return create
                .update(Account.ACCOUNT)
                .set(record)
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
