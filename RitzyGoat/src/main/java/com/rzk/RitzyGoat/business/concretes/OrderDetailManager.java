package com.rzk.RitzyGoat.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rzk.RitzyGoat.business.abstracts.OrderDetailService;
import com.rzk.RitzyGoat.core.utilities.results.DataResult;
import com.rzk.RitzyGoat.core.utilities.results.Result;
import com.rzk.RitzyGoat.core.utilities.results.SuccessDataResult;
import com.rzk.RitzyGoat.core.utilities.results.SuccessResult;
import com.rzk.RitzyGoat.dataAccess.abstracts.OrderDetailDao;

import com.rzk.RitzyGoat.entities.concretes.OrderDetail;

@Service
public class OrderDetailManager implements OrderDetailService {

	private OrderDetailDao orderDetailDao;

	@Autowired
	public OrderDetailManager(OrderDetailDao orderDetailDao) {

		this.orderDetailDao = orderDetailDao;
	
	}

	@Override
	public DataResult<List<OrderDetail>> getAll() {
		
		return new SuccessDataResult<List<OrderDetail>>(orderDetailDao.findAll(), "all order details listed!");
		
	}

	@Override
	public Result add(OrderDetail orderDetail) {
		
		orderDetailDao.save(orderDetail);
		return new SuccessResult("added new order detail");
		
	}
	
}
