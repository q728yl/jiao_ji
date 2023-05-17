package com.example.jiaoji_app_back.controller;

import com.example.jiaoji_app_back.constant.Constant;
import com.example.jiaoji_app_back.service.SignUpService;
import com.example.jiaoji_app_back.utils.msgutils.Msg;
import com.example.jiaoji_app_back.utils.msgutils.MsgCode;
import com.example.jiaoji_app_back.utils.msgutils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
public class SignUpController {

    @Autowired
    private SignUpService signUpService;
    @PostMapping
    @RequestMapping("/signup")
//    @ResponseStatus(HttpStatus.OK)
    public Msg login(@RequestBody Map<String, String> params){
        String userId = params.get(Constant.USER_ID);
        String actId = params.get(Constant.ACT_ID);

        if(signUpService.SignUp(Integer.parseInt(userId),Integer.parseInt(actId))){
            return MsgUtil.makeMsg(MsgCode.SUCCESS, MsgUtil.SIGNUP_SUCCESS_MSG);
        }else{
            return MsgUtil.makeMsg(MsgCode.ERROR);
        }
    }
}