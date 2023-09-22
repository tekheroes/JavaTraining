package com.ey.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ey.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

//	@Query("FROM Order WHERE portfolio.pid=:pid")
//	List<Order> findByPortfolio(int pid);
	
	List<Order> findByPortfolioPid(int pid);
}
