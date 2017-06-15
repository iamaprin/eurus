package io.vilya.eurus.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import io.vilya.eurus.core.bean.AccountResp;
import io.vilya.eurus.core.common.json.ResultCode;
import io.vilya.eurus.core.common.utils.AssertUtils;
import io.vilya.eurus.core.common.utils.BeanUtilsWrapper;
import io.vilya.eurus.core.dao.AccountMapper;
import io.vilya.eurus.core.entity.tables.records.AccountRecord;
import io.vilya.eurus.core.exception.EurusException;
import io.vilya.eurus.core.service.IAccountService;

/**
 * @author iamaprin
 * @time 2017年6月12日 下午10:50:08
 */

public enum AccountServiceImpl implements IAccountService {

    INSTANCE;

    private AccountMapper accountMapper = new AccountMapper();
    
    @Override
    public boolean save(AccountRecord record) {
        return accountMapper.save(record) > 0;
    }

    @Override
    public boolean remove(int id) {
        return accountMapper.remove(id) > 0;
    }
    
    @Override
    public boolean update(AccountResp account) {
        AssertUtils.notNull(account);
        
        AccountRecord record = new AccountRecord();
        BeanUtilsWrapper.copyProperties(record, account);
        return accountMapper.update(record) > 0;
    }
    
    @Override
    public List<AccountResp> list() {
        List<AccountRecord> records = accountMapper.list();
        List<AccountResp> accountResps = new ArrayList<>();
        AccountResp accountResp;
        for (AccountRecord record : records) {
            accountResp = new AccountResp();
            BeanUtilsWrapper.copyProperties(accountResp, record);
            accountResps.add(accountResp);
        }
        return accountResps;
    }

    @Override
    public AccountResp get(int id) {
        AccountRecord record = accountMapper.get(id);
        AccountResp accountResp = new AccountResp();
        
        if (record == null) {
            throw new EurusException(ResultCode.RECORD_NOT_FOUND);
        }
        
        BeanUtilsWrapper.copyProperties(accountResp, record);
        return accountResp;
    }
    
}
