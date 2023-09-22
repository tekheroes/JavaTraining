package com.ey.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ey.entity.Order;
import com.ey.entity.Portfolio;
import com.ey.entity.Stock;
import com.ey.repo.OrderRepository;
import com.ey.vo.Input;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private StockService stockService;
	
	@Autowired
	private PortfolioService portService;
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public boolean buyStock(Input input) {
		Stock s = stockService.getStock(input.getSid());
		Portfolio p = portService.getPortfolio(input.getPid());
		
		Order order = new Order();
		order.setQuantity(input.getQty());
		order.setTxnType("Buy");
		order.setTxnDate(LocalDate.now());
		order.setShare(s);
		order.setPortfolio(p);
		
		p.setInvestment((input.getQty() * s.getQuote()) + p.getInvestment());
		orderRepo.save(order);
		return true;
	}

	@Override
	public boolean sellStock(Input input) {
		Stock s = stockService.getStock(input.getSid());
		Portfolio p = portService.getPortfolio(input.getPid());
		
		Order order = new Order();
		order.setQuantity(input.getQty());
		order.setTxnType("Sell");
		order.setTxnDate(LocalDate.now());
		order.setShare(s);
		order.setPortfolio(p);
		
		p.setInvestment((input.getQty() * s.getQuote()) - p.getInvestment());
		orderRepo.save(order);
		return true;
	}
}
