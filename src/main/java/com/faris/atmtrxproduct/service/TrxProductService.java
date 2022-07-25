package com.faris.atmtrxproduct.service;

import java.util.List;

import com.faris.atmtrxproduct.entity.Customer;
import com.faris.atmtrxproduct.entity.TrxProduct;
import com.faris.atmtrxproduct.entity.TrxProductDetail;

public interface TrxProductService {
	public List<TrxProduct> findAll();
	
	public TrxProduct findById(int theId);
	
	public void save(TrxProduct theProduct);
	
	public void deleteById(int theId);

	public List<TrxProduct> searchBy(String theName);
	
	public List<TrxProductDetail> findAllTrxDetail();
	
	public List<TrxProductDetail> findAllTrxDetailByContainsName(String name);
	
	public TrxProductDetail findTrxDetailById(int id);
	
	public void save(Customer theCustomer);
	
	public Customer findById(Integer Id);
}
