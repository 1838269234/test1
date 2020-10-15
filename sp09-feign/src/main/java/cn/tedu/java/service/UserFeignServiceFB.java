package cn.tedu.java.service;

import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class UserFeignServiceFB implements UserFeignService{

    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("获取用户失败");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("增加用户积分");
    }
}
