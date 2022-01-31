package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.OrderService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.OrderDao;
import com.rzk.RitzyGoat.entities.concretes.Order;

@Service
public class OrderManager implements OrderService {

	private OrderDao orderDao;

	@Autowired
	public OrderManager(OrderDao orderDao) {

		this.orderDao = orderDao;
	
	}

	@Override
	public DataResult<List<Order>> getAll() {
		
		return new SuccessDataResult<List<Order>>(orderDao.findAll(), "all orders listed!");
		
	}

	@Override
	public Result add(Order order) {
		
		orderDao.save(order);
		return new SuccessResult("added new order");
		
	}
	
}
