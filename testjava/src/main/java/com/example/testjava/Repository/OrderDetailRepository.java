package com.example.testjava.Repository;

import com.example.testjava.Entity.OrderDetail;
import com.example.testjava.Entity.OrderDetailPK;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, OrderDetailPK> {


}
