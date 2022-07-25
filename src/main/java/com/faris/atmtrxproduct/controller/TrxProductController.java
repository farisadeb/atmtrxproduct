package com.faris.atmtrxproduct.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faris.atmtrxproduct.entity.Customer;
import com.faris.atmtrxproduct.entity.TrxProduct;
import com.faris.atmtrxproduct.entity.TrxProductDetail;
import com.faris.atmtrxproduct.service.TrxProductService;

@RestController
@RequestMapping("api/v1/trxproduct")
public class TrxProductController {
	private TrxProductService trxProductService;
	
	@Autowired
	public TrxProductController(TrxProductService trxProdService)
	{
		trxProductService = trxProdService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<TrxProduct>> getListTrxProduct()
	{
		List<TrxProduct> listProduct = null;
		
		try {
			listProduct = trxProductService.findAll();
			
			return new ResponseEntity<>(listProduct, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/listdetail")
	public ResponseEntity<List<TrxProductDetail>> getListTrxProductDetail()
	{
		List<TrxProductDetail> listProductDetail = null;
		
		try {
			listProductDetail = trxProductService.findAllTrxDetail();
			
			return new ResponseEntity<>(listProductDetail, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/search/{id}")
	public ResponseEntity<TrxProduct> searchTrxProductById(@PathVariable("id") int id)
	{
		TrxProduct product = null;
		
		try {
			product = trxProductService.findById(id);
			
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/buy")
	public ResponseEntity<String> saveTrxProduct(@RequestBody TrxProduct prod)
	{
		Customer cust = new Customer();
		Integer intId = null;
		
		try {
			intId = prod.getCid();
			cust = trxProductService.findById(intId);
			
			if(cust.getSaldo().doubleValue() >= prod.getJumlahInvest().doubleValue())
			{
				prod.setHistoryDt(LocalDateTime.now());
				cust.setSaldo(cust.getSaldo().doubleValue() - prod.getJumlahInvest().doubleValue());
				trxProductService.save(prod);
				trxProductService.save(cust);

				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/sell/{id}")
	public ResponseEntity<String> updateProduct(@PathVariable("id") int id) {
		TrxProduct prodData = null;
		TrxProductDetail trxProdData = null;
		Customer cust = null;
		Integer intId = null;
		
		// diff day for interest
		long diffDay = 0;
		int iDiffDay = 0;
		LocalDate ldFirst = null;
		LocalDate ldSecond = null;
		
		// calculate
		int calcInterest = 0;
		
		try {
			prodData = trxProductService.findById(id);
			trxProdData = trxProductService.findTrxDetailById(id);
			
			intId = prodData.getCid();
			cust = trxProductService.findById(intId);

			ldFirst = prodData.getHistoryDt().toLocalDate();
			ldSecond = LocalDate.now();
			
			diffDay = ldFirst.until(ldSecond, ChronoUnit.DAYS);
			iDiffDay = (int)diffDay;
			
			if(iDiffDay % (365*trxProdData.getReturnYear())==0 )
			{
				calcInterest = iDiffDay/(365 * trxProdData.getReturnYear());
				calcInterest = calcInterest * trxProdData.getReturnPersenYear();
				
				prodData.setHistoryDt(LocalDateTime.now());
				cust.setSaldo(cust.getSaldo().doubleValue() + (prodData.getJumlahInvest().doubleValue() * ((100 + calcInterest)/100)));
				trxProductService.save(prodData);
				trxProductService.save(cust);

				return new ResponseEntity<>(HttpStatus.OK);
			}
			else 
			{
				prodData.setHistoryDt(LocalDateTime.now());
				cust.setSaldo(cust.getSaldo().doubleValue() + prodData.getJumlahInvest().doubleValue());
				trxProductService.save(prodData);
				trxProductService.save(cust);

				return new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/searchorder")
	public ResponseEntity<List<TrxProduct>> getListTrxProductByContainsNameAndOrderByNameAsc(@RequestParam("name") String name)
	{
		List<TrxProduct> listProduct = null;
		List<TrxProduct> finalListProduct = null;
		
		try {
			listProduct = trxProductService.searchBy(name);
			finalListProduct = listProduct.stream().sorted().collect(Collectors.toList());
			
			return new ResponseEntity<>(finalListProduct ,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		finally {
			listProduct = null;
		}
	}
}
