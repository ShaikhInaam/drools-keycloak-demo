package com.vd.drools.controller;

import com.vd.drools.BaseResponse;
import com.vd.drools.request.ProvidentFundRequest;
import com.vd.drools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;


@RestController
@RequestMapping("/")
public class UserController {


    @Autowired
    UserService userService;

    @RolesAllowed("user")
    @RequestMapping(value = "provident-cut-user", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> getProvidentCutForUser(@Valid @RequestBody ProvidentFundRequest request){


        BaseResponse responseObject = userService.getProvidentFund(request);
        return ResponseEntity.ok(responseObject);

    }


    @RequestMapping(value = "provident-cut-general", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> getProvidentCutForOthers(@Valid @RequestBody ProvidentFundRequest request){


        BaseResponse responseObject = userService.getProvidentFund(request);
        return ResponseEntity.ok(responseObject);

    }


    @RolesAllowed("admin")
    @RequestMapping(value = "provident-cut-admin", method = RequestMethod.POST)
    public ResponseEntity<BaseResponse> getProvidentCutForAdmin(@Valid @RequestBody ProvidentFundRequest request){


        BaseResponse responseObject = userService.getProvidentFund(request);
        return ResponseEntity.ok(responseObject);

    }

}
