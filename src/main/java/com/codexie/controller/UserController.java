package com.codexie.controller;

import cn.hutool.core.util.RandomUtil;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.codexie.common.R;
import com.codexie.constant.AliyunConstant;
import com.codexie.dto.ValidationCode;
import com.codexie.pojo.User;
import com.codexie.service.UserService;
import com.codexie.util.SMSUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("code")
    public R validateCode(String phone){
        String code = RandomUtil.randomNumbers(4).toString();
        stringRedisTemplate.opsForValue().set("user:phone:"+phone,code);
//        try {
//            SMSUtils.sendSms(phone,code);
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return R.error(e.getErrMsg());
//        }
        return R.success(code);
    }

    @PostMapping("login")
    public R login(@RequestBody ValidationCode validationCode, HttpSession session){
        String phone = validationCode.getPhone();
        if(validationCode.getCode().equals(stringRedisTemplate.opsForValue().get("user:phone:"+ phone))){
            User user = userService.query().eq("phone",phone ).one();
            if(user == null){
                user = new User();
                user.setPhone(phone);
                user.setName("新用户"+RandomUtil.randomString(6));
                userService.save(user);
            }
            session.setAttribute("user",user);
            return R.success("登陆成功");
        }
        return R.error("登录失败");
    }




}
