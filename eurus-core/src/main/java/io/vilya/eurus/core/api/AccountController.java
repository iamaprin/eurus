package io.vilya.eurus.core.api;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vilya.eurus.core.bean.AccountResp;
import io.vilya.eurus.core.common.json.APIListJson;
import io.vilya.eurus.core.common.json.APIObjectJson;
import io.vilya.eurus.core.common.json.APIRespJson;
import io.vilya.eurus.core.common.json.ResultCode;
import io.vilya.eurus.core.service.impl.AccountServiceImpl;

/**
 * @author iamaprin
 * @time 2017年6月8日 下午10:21:27
 */
@Path("account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);
    
    @GET
    @Path("/{id}")
    public APIRespJson account(@QueryParam("id") int id) {        
        AccountResp account = AccountServiceImpl.INSTANCE.get(id);
        return new APIObjectJson<>(account);
    }
    
    @GET
    public APIRespJson list() {
        List<AccountResp> accounts = AccountServiceImpl.INSTANCE.list();
        return new APIListJson<>(accounts);
    }
    
    @PUT
    public APIRespJson update(@BeanParam AccountResp account) {
        boolean result = AccountServiceImpl.INSTANCE.update(account);
        return new APIRespJson(result ? ResultCode.SUCC : ResultCode.FAIL);
    }
    
    @POST
    public APIRespJson add(@BeanParam AccountResp account) {
        boolean result = AccountServiceImpl.INSTANCE.save(account);
        return new APIRespJson(result ? ResultCode.SUCC : ResultCode.FAIL);
    }
    
    
    
    
    
    
    
}
