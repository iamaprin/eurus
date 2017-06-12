package io.vilya.eurus.core.dao;

import java.util.List;

import io.vilya.eurus.core.entity.tables.Perm;
import io.vilya.eurus.core.entity.tables.records.PermRecord;

/**
 * @author iamaprin
 * @time 2017年6月12日 下午11:23:54
 */
public class PermMapper extends AbstractMapper {
    
    public boolean save(PermRecord record) {
        return create
                .insertInto(Perm.PERM)
                .set(record)
                .execute() > 0;
    }
    
    public boolean remove(int id) {
        return create
                .deleteFrom(Perm.PERM)
                .where(Perm.PERM.ID.eq(id))
                .execute() > 0;
    }
    
    public boolean update(PermRecord record) {
        return create
                .update(Perm.PERM)
                .set(record)
                .execute() > 0;
    }
    
    public List<PermRecord> list() {
        return create
                .selectFrom(Perm.PERM)
                .where(Perm.PERM.IS_DELETED.eq(false))
                .fetch();
    }
    
    public PermRecord get(int id) {
        return create
                .selectFrom(Perm.PERM)
                .where(Perm.PERM.ID.eq(id))
                .and(Perm.PERM.IS_DELETED.eq(false))
                .fetchAny();
    }
    
}
