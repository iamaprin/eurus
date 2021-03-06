/*
 * This file is generated by jOOQ.
*/
package io.vilya.eurus.core.entity.tables;


import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import io.vilya.eurus.core.entity.DbVyCore;
import io.vilya.eurus.core.entity.Keys;
import io.vilya.eurus.core.entity.tables.records.AccountRMemberRecord;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.3"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AccountRMember extends TableImpl<AccountRMemberRecord> {

    private static final long serialVersionUID = 1412972102;

    /**
     * The reference instance of <code>DB_VY_CORE.account_r_member</code>
     */
    public static final AccountRMember ACCOUNT_R_MEMBER = new AccountRMember();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AccountRMemberRecord> getRecordType() {
        return AccountRMemberRecord.class;
    }

    /**
     * The column <code>DB_VY_CORE.account_r_member.id</code>.
     */
    public final TableField<AccountRMemberRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB_VY_CORE.account_r_member.account_id</code>.
     */
    public final TableField<AccountRMemberRecord, Integer> ACCOUNT_ID = createField("account_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB_VY_CORE.account_r_member.member_id</code>.
     */
    public final TableField<AccountRMemberRecord, Integer> MEMBER_ID = createField("member_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>DB_VY_CORE.account_r_member.create_time</code>.
     */
    public final TableField<AccountRMemberRecord, Date> CREATE_TIME = createField("create_time", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>DB_VY_CORE.account_r_member.update_time</code>.
     */
    public final TableField<AccountRMemberRecord, Date> UPDATE_TIME = createField("update_time", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>DB_VY_CORE.account_r_member.is_deleted</code>.
     */
    public final TableField<AccountRMemberRecord, Boolean> IS_DELETED = createField("is_deleted", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * Create a <code>DB_VY_CORE.account_r_member</code> table reference
     */
    public AccountRMember() {
        this("account_r_member", null);
    }

    /**
     * Create an aliased <code>DB_VY_CORE.account_r_member</code> table reference
     */
    public AccountRMember(String alias) {
        this(alias, ACCOUNT_R_MEMBER);
    }

    private AccountRMember(String alias, Table<AccountRMemberRecord> aliased) {
        this(alias, aliased, null);
    }

    private AccountRMember(String alias, Table<AccountRMemberRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DbVyCore.DB_VY_CORE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<AccountRMemberRecord, Integer> getIdentity() {
        return Keys.IDENTITY_ACCOUNT_R_MEMBER;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<AccountRMemberRecord> getPrimaryKey() {
        return Keys.KEY_ACCOUNT_R_MEMBER_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<AccountRMemberRecord>> getKeys() {
        return Arrays.<UniqueKey<AccountRMemberRecord>>asList(Keys.KEY_ACCOUNT_R_MEMBER_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountRMember as(String alias) {
        return new AccountRMember(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public AccountRMember rename(String name) {
        return new AccountRMember(name, null);
    }
}
