package com.faris.atmtrxproduct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faris.atmtrxproduct.entity.Customer;
import com.faris.atmtrxproduct.entity.TrxProduct;
import com.faris.atmtrxproduct.entity.TrxProductDetail;
import com.faris.atmtrxproduct.repository.CustomerRepository;
import com.faris.atmtrxproduct.repository.TrxProductRepository;

@Service
public class TrxProductServiceImpl implements TrxProductService {
	
	private TrxProductRepository trxProductRepository;
	
	private CustomerRepository customerRepository;
	
	@Autowired
	public TrxProductServiceImpl(TrxProductRepository trxProdRepository)
	{
		trxProductRepository = trxProdRepository;
	}
	
	@Override
	public List<TrxProduct> findAll() {
		return trxProductRepository.findAllByOrderNameAsc();
	}
	
	@Override
	public List<TrxProductDetail> findAllTrxDetail() {
		List<TrxProductDetail> lisTrxProductDetail = trxProductRepository.findAllTrxDetail();
		
		return lisTrxProductDetail;
	}

	@Override
	public TrxProduct findById(int theId) {
		Optional<TrxProduct> result = trxProductRepository.findById(theId);
		
		TrxProduct theTrxProduct = null;
		
		if (result.isPresent()) {
			theTrxProduct = result.get();
		}
		else {
			throw new RuntimeException("Did not find TrxProduct id - " + theId);
		}
		
		return theTrxProduct;
	}

	@Override
	public void save(TrxProduct theTrxProduct) {
		trxProductRepository.save(theTrxProduct);
	}

	@Override
	public void deleteById(int theId) {
		trxProductRepository.deleteById(theId);
	}

	@Override
	public List<TrxProduct> searchBy(String theName) {
		
		List<TrxProduct> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = trxProductRepository.findByContainsName(theName);
		}
		else {
			results = findAll();
		}
		
		return results;
	}
	
	@Override
	public List<TrxProductDetail> findAllTrxDetailByContainsName(String theName) {
		
		List<TrxProductDetail> results = null;
		
		if (theName != null && (theName.trim().length() > 0)) {
			results = trxProductRepository.findAllTrxDetailByContainsName(theName);
		}
		else {
			results = findAllTrxDetail();
		}
		
		return results;
	}
	
	@Override
	public TrxProductDetail findTrxDetailById(int id) {
		TrxProductDetail result = trxProductRepository.findTrxDetailById(id);
		
		TrxProductDetail theTrxProduct = null;
		
		if (result != null) {
			theTrxProduct = result;
		}
		else {
			throw new RuntimeException("Did not find TrxProduct id - " + id);
		}
		
		return theTrxProduct;
	}
	
	@Override
	public void save(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}
	
	@Override
	public Customer findById(Integer Id) {
		Optional<Customer> result = customerRepository.findById(Id);
		
		Customer theCustomer = null;
		
		if (result.isPresent()) {
			theCustomer = result.get();
		}
		else {
			throw new RuntimeException("Did not find Customer id - " + Id);
		}
		
		return theCustomer;
	}
}
