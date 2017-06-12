package io.vilya.eurus.core.dao;

import java.util.List;

import io.vilya.eurus.core.entity.tables.Role;
import io.vilya.eurus.core.entity.tables.records.RoleRecord;

/**
 * @author iamaprin
 * @time 2017年6月12日 下午11:15:14
 */
public class RoleMapper extends AbstractMapper {
    
    public boolean save(RoleRecord record) {
        return create
                .insertInto(Role.ROLE)
                .set(record)
                .execute() > 0;
    }
    
    public boolean remove(int id) {
        return create
                .deleteFrom(Role.ROLE)
                .where(Role.ROLE.ID.eq(id))
                .execute() > 0;
    }
    
    public boolean update(RoleRecord record) {
        return create
                .update(Role.ROLE)
                .set(record)
                .execute() > 0;
    }
    
    public List<RoleRecord> list() {
        return create
                .selectFrom(Role.ROLE)
                .where(Role.ROLE.IS_DELETED.eq(false))
                .fetch();
    }
    
    public RoleRecord get(int id) {
        return create
                .selectFrom(Role.ROLE)
                .where(Role.ROLE.ID.eq(id))
                .and(Role.ROLE.IS_DELETED.eq(false))
                .fetchAny();
    }
    
    
    
    
    
    
    
    
    
    
}
