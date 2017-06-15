package io.vilya.eurus.core.service;

import java.util.List;

import io.vilya.eurus.core.bean.AccountResp;
import io.vilya.eurus.core.entity.tables.records.AccountRecord;

/**
 * @author iamaprin
 * @time 2017年6月12日 下午10:49:52
 */
public interface IAccountService {
        
    List<AccountResp> list();
    
    AccountResp get(int id);
    
    boolean update(AccountResp record);
    
    boolean save(AccountRecord record);
    
    boolean remove(int id);
    
}
