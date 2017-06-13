package io.vilya.eurus.core.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.Configuration;
import org.jooq.util.jaxb.Database;
import org.jooq.util.jaxb.ForcedType;
import org.jooq.util.jaxb.Generator;
import org.jooq.util.jaxb.Jdbc;
import org.jooq.util.jaxb.Property;
import org.jooq.util.jaxb.Target;

/**
 * @author iamaprin
 * @time 2017年6月11日 下午10:54:17
 */
public class CodeGenUtils {

    public static void main(String[] args) throws Exception {
        Target target = new Target();
        target.setPackageName("generated");
        
        List<Property> properties = new ArrayList<>();
        properties.add(new Property().withKey("dialect").withValue("MYSQL"));
        
        Configuration configuration = new Configuration();
        configuration.withJdbc(new Jdbc()
                .withDriver("com.mysql.jdbc.Driver")
                .withUrl("jdbc:mysql://127.0.0.1:3306/DB_VY_CORE?serverTimezone=UTC&characterEncoding=utf-8")
                .withProperties()
                .withUsername("eurus")
                .withPassword("123456"));
        configuration.withGenerator(new Generator()
                .withDatabase(new Database()
                        .withName("org.jooq.util.mysql.MySQLDatabase")
                        .withForcedTypes(
                                new ForcedType()
                                    .withName("BOOLEAN")
                                    .withExpression(".*\\.is_deleted")
                                    .withTypes(".*"),
                                new ForcedType()
                                    .withName("Date")
                                    .withExpression(".*\\..*_time")
                                    .withTypes(".*")
                               )
                        .withUnsignedTypes(false))
                .withTarget(new Target()
                        .withDirectory("src/main/java")
                        .withPackageName("io.vilya.eurus.core.generated")));
        GenerationTool.generate(configuration);
        
    }
    
    
    
    
    
    
}
