package cn.tedu.sp04.order.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp04.order.feignclient.ItemFeignService;
import cn.tedu.sp04.order.feignclient.UserFeignService;
import cn.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.service.OrderService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private ItemFeignService itemFeignService;

	@Autowired
	private UserFeignService userFeignService;

	@Override
	public Order getOrder(String orderId) {
		//调用user-service获取用户信息
		JsonResult<User> user=userFeignService.getUser(7);
		// 调用item-service获取商品信息
		JsonResult<List<Item>> items = itemFeignService.getItems(orderId);
		Order order = new Order();
		order.setUser(user.getData());
		order.setId(orderId);
		order.setItems(items.getData());
		return order;
	}

	@Override
	public void addOrder(Order order) {
		//调用item-service减少商品库存
		itemFeignService.decreaseNumber(order.getItems());

		// 调用user-service增加用户积分
		userFeignService.addScore(order.getUser().getId(),100);
		log.info("保存订单："+order);
	}

}