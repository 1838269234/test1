package cn.tedu.java.service;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class OrderFeignServiceFB implements OrderFeignService{
    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("获取订单失败");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("保存订单失败");
    }
}
