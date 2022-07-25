package com.faris.atmtrxproduct.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_trx_produk_investasi")
public class TrxProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="c_id")
	private int Cid;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="pi_id")
	private int tpId;
	
	@Column(name="action")
	private String action;
	
	@Column(name="jumlah_invest")
	private Double jumlahInvest;
	
	@Column(name="history_dt")
	private LocalDateTime historyDt;
	
	@Column(name="cre_name")
	private String creName;
	
	public TrxProduct() {
		
	}

	public TrxProduct(int id, int cid, String nama, int tpId, String action, Double jumlahInvest,
			LocalDateTime historyDt, String creName) {
		super();
		this.id = id;
		Cid = cid;
		this.nama = nama;
		this.tpId = tpId;
		this.action = action;
		this.jumlahInvest = jumlahInvest;
		this.historyDt = historyDt;
		this.creName = creName;
	}
	
	public TrxProduct( int cid, String nama, int tpId, String action, Double jumlahInvest,
			LocalDateTime historyDt, String creName) {
		super();
		Cid = cid;
		this.nama = nama;
		this.tpId = tpId;
		this.action = action;
		this.jumlahInvest = jumlahInvest;
		this.historyDt = historyDt;
		this.creName = creName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return Cid;
	}

	public void setCid(int cid) {
		Cid = cid;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getTpId() {
		return tpId;
	}

	public void setTpId(int tpId) {
		this.tpId = tpId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Double getJumlahInvest() {
		return jumlahInvest;
	}

	public void setJumlahInvest(Double jumlahInvest) {
		this.jumlahInvest = jumlahInvest;
	}

	public LocalDateTime getHistoryDt() {
		return historyDt;
	}

	public void setHistoryDt(LocalDateTime historyDt) {
		this.historyDt = historyDt;
	}

	public String getCreName() {
		return creName;
	}

	public void setCreName(String creName) {
		this.creName = creName;
	}

	@Override
	public String toString() {
		return "TrxProduct [id=" + id + ", Cid=" + Cid + ", nama=" + nama + ", tpId=" + tpId + ", action=" + action
				+ ", jumlahInvest=" + jumlahInvest + ", historyDt=" + historyDt + ", creName=" + creName + "]";
	}
	
	
}
