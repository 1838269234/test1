package cn.tedu.java.controller;

import cn.tedu.java.service.ItemFeignService;
import cn.tedu.java.service.OrderFeignService;
import cn.tedu.java.service.UserFeignService;
import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeignController {

    @Autowired
    private ItemFeignService itemFeignService;

    @Autowired
    private UserFeignService userFeignService;

    @Autowired
    private OrderFeignService orderFeignService;

    @GetMapping("/item-service/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId){
        return itemFeignService.getItems(orderId);
    }
    @PostMapping("/item-service/decreaseNumber")
    public JsonResult decreaseNumber(@RequestBody List<Item> items){
        return itemFeignService.decreaseNumber(items);
    }

    @GetMapping("/user-service/{userId}")
    public JsonResult<User> getUser(@PathVariable Integer userId){
        return userFeignService.getUser(userId);
    }
    @GetMapping("/user-service/{userId}/score")
    public JsonResult getScore(@PathVariable Integer userId,@RequestParam Integer score){
        return userFeignService.addScore(userId,score);
    }

    @GetMapping("/order-service/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId){
        return orderFeignService.getOrder(orderId);
    }
    @GetMapping("/order-service/")
    public JsonResult addOrder(){
        return orderFeignService.addOrder();
    }
}
