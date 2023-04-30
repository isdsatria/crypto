package com.achsat.crypto.order.repository;

import com.achsat.crypto.dto.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository <Order, Long> {

}
