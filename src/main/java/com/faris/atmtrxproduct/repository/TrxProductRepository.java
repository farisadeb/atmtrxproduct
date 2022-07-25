package com.faris.atmtrxproduct.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faris.atmtrxproduct.entity.TrxProduct;
import com.faris.atmtrxproduct.entity.TrxProductDetail;


@Repository
public interface TrxProductRepository extends JpaRepository<TrxProduct, Integer> {
	
	@Query(value="SELECT p.* FROM tbl_trx_produk_investasi p "
			+ " ORDER BY nama ASC",
			nativeQuery=true)
	public List<TrxProduct> findAllByOrderNameAsc();
	
	@Query(value="SELECT p.* FROM tbl_trx_produk_investasi p "
			+ " WHERE p.nama LIKE %?1%",
			nativeQuery=true)
	public List<TrxProduct> findByContainsName(String name);
	
	@Query(value="SELECT p.id, p.nama as p_nama, p.c_id, c.nama as c_nama, p.pi_id, pi.nama as pi_nama, tp.nama as tp_nama, pi.return_year, pi.return_persen_year, p.action,p.jumlah_invest "
			+ " FROM tbl_trx_produk_investasi p"
			+ " JOIN tbl_customer c"
			+ " ON c.id = p.c_id"
			+ " JOIN tbl_produk_investasi pi"
			+ " ON pi.id = p.pi_id"
			+ " JOIN tbl_tipe_produk tp"
			+ " ON tp.id = pi.tp_id",
			nativeQuery=true
			)
	public List<TrxProductDetail> findAllTrxDetail();
	
	@Query(value="SELECT p.id, p.nama as p_nama, p.c_id, c.nama as c_nama, p.pi_id, pi.nama as pi_nama, tp.nama as tp_nama, pi.return_year, pi.return_persen_year, p.action,p.jumlah_invest "
			+ " FROM tbl_trx_produk_investasi p"
			+ " JOIN tbl_customer c"
			+ " ON c.id = p.c_id"
			+ " JOIN tbl_produk_investasi pi"
			+ " ON pi.id = p.pi_id"
			+ " JOIN tbl_tipe_produk tp"
			+ " ON tp.id = pi.tp_id"
			+ " WHERE p.nama LIKE %?1%",
			nativeQuery=true
			)
	public List<TrxProductDetail> findAllTrxDetailByContainsName(String name);
	
	@Query(value="SELECT p.id, p.nama as p_nama, p.c_id, c.nama as c_nama, p.pi_id, pi.nama as pi_nama, tp.nama as tp_nama, pi.return_year, pi.return_persen_year, p.action,p.jumlah_invest "
			+ " FROM tbl_trx_produk_investasi p"
			+ " JOIN tbl_customer c"
			+ " ON c.id = p.c_id"
			+ " JOIN tbl_produk_investasi pi"
			+ " ON pi.id = p.pi_id"
			+ " JOIN tbl_tipe_produk tp"
			+ " ON tp.id = pi.tp_id"
			+ " WHERE p.id = ?1",
			nativeQuery=true
			)
	public TrxProductDetail findTrxDetailById(int id);
	
}
