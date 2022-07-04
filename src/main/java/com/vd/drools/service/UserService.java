package com.vd.drools.service;

import com.vd.drools.BaseResponse;
import com.vd.drools.request.ProvidentFundRequest;
import com.vd.drools.response.ProvidentFundResponse;

public interface UserService {

    BaseResponse getProvidentFund(ProvidentFundRequest request);
}
