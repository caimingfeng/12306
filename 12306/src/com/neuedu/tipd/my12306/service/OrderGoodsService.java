package com.neuedu.tipd.my12306.service;

import com.neuedu.tipd.my12306.bean.OrderGoods;

/*
 * 订单 
 */

public interface OrderGoodsService {
	
	/*
	 * 新增
	 * 
	 * @author Game
	 * 
	 * @Param OrderGoods
	 * 
	 * @return boolean
	 * 
	 */
	public boolean addOrderGoods(OrderGoods ordergoods);
	
	/*
	 * 删除
	 * 
	 * @author Game
	 * 
	 * @Param 
	 * 
	 * @return
	 * 
	 */
	public boolean deleteOrderGoods(int orderGoodsId);
	
	/*
	 * 按ID修改
	 * 
	 * @author Game
	 * 
	 * @Param OrderGoods
	 * 
	 * @return boolean
	 * 
	 */
	public boolean updateOrderGoods(OrderGoods orderGoods);
	
	/*
	 * 按用户ID查找
	 * 
	 * @author Game
	 * 
	 * @Param String
	 * 
	 * @return OrderGoods
	 */
	public OrderGoods findOrderGoodsByUserId(String userId);
}
