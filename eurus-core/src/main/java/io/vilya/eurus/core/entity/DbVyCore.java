/*
 * This file is generated by jOOQ.
*/
package io.vilya.eurus.core.entity;


import io.vilya.eurus.core.entity.tables.Account;
import io.vilya.eurus.core.entity.tables.AccountRMember;
import io.vilya.eurus.core.entity.tables.AccountRRole;
import io.vilya.eurus.core.entity.tables.Member;
import io.vilya.eurus.core.entity.tables.Perm;
import io.vilya.eurus.core.entity.tables.PermRRole;
import io.vilya.eurus.core.entity.tables.Role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;


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
public class DbVyCore extends SchemaImpl {

    private static final long serialVersionUID = -1458700189;

    /**
     * The reference instance of <code>DB_VY_CORE</code>
     */
    public static final DbVyCore DB_VY_CORE = new DbVyCore();

    /**
     * The table <code>DB_VY_CORE.account</code>.
     */
    public final Account ACCOUNT = io.vilya.eurus.core.entity.tables.Account.ACCOUNT;

    /**
     * The table <code>DB_VY_CORE.account_r_member</code>.
     */
    public final AccountRMember ACCOUNT_R_MEMBER = io.vilya.eurus.core.entity.tables.AccountRMember.ACCOUNT_R_MEMBER;

    /**
     * The table <code>DB_VY_CORE.account_r_role</code>.
     */
    public final AccountRRole ACCOUNT_R_ROLE = io.vilya.eurus.core.entity.tables.AccountRRole.ACCOUNT_R_ROLE;

    /**
     * The table <code>DB_VY_CORE.member</code>.
     */
    public final Member MEMBER = io.vilya.eurus.core.entity.tables.Member.MEMBER;

    /**
     * The table <code>DB_VY_CORE.perm</code>.
     */
    public final Perm PERM = io.vilya.eurus.core.entity.tables.Perm.PERM;

    /**
     * The table <code>DB_VY_CORE.perm_r_role</code>.
     */
    public final PermRRole PERM_R_ROLE = io.vilya.eurus.core.entity.tables.PermRRole.PERM_R_ROLE;

    /**
     * The table <code>DB_VY_CORE.role</code>.
     */
    public final Role ROLE = io.vilya.eurus.core.entity.tables.Role.ROLE;

    /**
     * No further instances allowed
     */
    private DbVyCore() {
        super("DB_VY_CORE", null);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        List result = new ArrayList();
        result.addAll(getTables0());
        return result;
    }

    private final List<Table<?>> getTables0() {
        return Arrays.<Table<?>>asList(
            Account.ACCOUNT,
            AccountRMember.ACCOUNT_R_MEMBER,
            AccountRRole.ACCOUNT_R_ROLE,
            Member.MEMBER,
            Perm.PERM,
            PermRRole.PERM_R_ROLE,
            Role.ROLE);
    }
}
