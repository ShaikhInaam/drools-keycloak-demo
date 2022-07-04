package com.vd.drools.service;

import com.vd.drools.BaseResponse;
import com.vd.drools.request.ProvidentFundRequest;
import com.vd.drools.response.ProvidentFundResponse;
import com.vd.drools.util.Constants;
import org.kie.api.KieBase;
import org.kie.api.builder.model.KieSessionModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private KieContainer kieContainer;


    public BaseResponse getProvidentFund(ProvidentFundRequest request)
    {

        ProvidentFundResponse response = new ProvidentFundResponse();
        response.setDepartment(request.getDepartment().toUpperCase(Locale.ROOT));
        response.setExperience(request.getExperience());

        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("response", response);
        kieSession.insert(request);
        kieSession.fireAllRules();
        kieSession.dispose();

        BaseResponse baseResponse = BaseResponse.builder().responseCode(Constants.SUCCESS_RESPONSE_CODE)
                .responseMessage(Constants.SUCCESS_RESPONSE_MESSAGE).response(response).build();

        return baseResponse;

    }


}
