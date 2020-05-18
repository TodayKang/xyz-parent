package com.xyz.sync.core.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.xyz.sync.api.entity.OrderUserVO;
import com.xyz.sync.api.service.IOrderUserService;
import com.xyz.sync.core.repository.IOrderUserRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrderUserService implements IOrderUserService {

	@Autowired
	private IOrderUserRepository orderUserRepository;

	@Override
	public OrderUserVO save(OrderUserVO arg) {
		Assert.notNull(arg, "入参不能为空!");

		orderUserRepository.save(arg);
		return orderUserRepository.queryById(arg.getOrderUserId());
	}

	@Override
	public List<OrderUserVO> save(List<OrderUserVO> list) {
		Assert.notEmpty(list, "入参不能为空!");

		orderUserRepository.saveBatch(list);
		return list;
	}

	@Override
	public Boolean delete(Map<String, ?> map) {
		map = MapUtils.isEmpty(map) ? new HashMap<>() : map;

		orderUserRepository.delete(map);
		return Boolean.TRUE;
	}

	@Override
	public OrderUserVO update(OrderUserVO arg) {
		Assert.notNull(arg, "入参不能为空!");

		orderUserRepository.update(arg);
		return orderUserRepository.queryById(arg.getOrderUserId());
	}

	@Override
	public List<OrderUserVO> update(List<OrderUserVO> list) {
		Assert.notEmpty(list, "入参不能为空!");

		orderUserRepository.updateBatch(list);
		return list;
	}

	@Override
	public OrderUserVO query(Long id) {
		Assert.notNull(id, "入参不能为空!");

		log.info("OrderUserService.query:{}", id);
		return orderUserRepository.queryById(id);
	}

	@Override
	public List<OrderUserVO> query(Map<String, ?> map) {
		map = MapUtils.isEmpty(map) ? new HashMap<>() : map;

		log.info("OrderUserService.query:{}", map);
		return orderUserRepository.query(map);
	}

	@Override
	public Long size(Map<String, ?> map) {
		map = MapUtils.isEmpty(map) ? new HashMap<>() : map;

		log.info("OrderUserService.size:{}", map);
		return orderUserRepository.size(map);
	}

}
