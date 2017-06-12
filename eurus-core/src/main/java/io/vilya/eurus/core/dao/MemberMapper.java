package io.vilya.eurus.core.dao;

import java.util.List;

import io.vilya.eurus.core.entity.tables.Member;
import io.vilya.eurus.core.entity.tables.records.MemberRecord;

/**
 * 成员信息
 * @author iamaprin
 * @time 2017年6月12日 下午11:00:20
 */
public class MemberMapper extends AbstractMapper {
    
    public boolean save(MemberRecord record) {
        return create
                .insertInto(Member.MEMBER)
                .set(record)
                .execute() > 0;
    }
    
    public boolean remove(int id) {
        return create
                .deleteFrom(Member.MEMBER)
                .where(Member.MEMBER.ID.eq(id))
                .execute() > 0;
    }
    
    public boolean update(MemberRecord record) {
        return create
                .update(Member.MEMBER)
                .set(record)
                .execute() > 0;
    }
    
    public List<MemberRecord> list() {
        return create
                .selectFrom(Member.MEMBER)
                .where(Member.MEMBER.IS_DELETED.eq(false))
                .fetch();
    }
    
    public MemberRecord get(int id) {
        return create
                .selectFrom(Member.MEMBER)
                .where(Member.MEMBER.ID.eq(id))
                .and(Member.MEMBER.IS_DELETED.eq(false))
                .fetchOne();
    }
}
