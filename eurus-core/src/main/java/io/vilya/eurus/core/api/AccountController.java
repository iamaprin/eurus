package io.vilya.eurus.core.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author iamaprin
 * @time 2017年6月8日 下午10:21:27
 */
@Path("account")
public class AccountController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    
    @GET
    public String account() {
        LOGGER.info("123");
        return "123";
    }
}
