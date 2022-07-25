package com.faris.atmtrxproduct.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;

public class TrxProductDetail {
	@Column(name="id")
	private int id;
	
	@Column(name="nama")
	private String nama;
	
	@Column(name="c_id")
	private int cId;
	
	@Column(name="c_nama")
	private String cNama;
	
	@Column(name="pi_id")
	private int piId;

	@Column(name="pi_nama")
	private String piNama;
	
	@Column(name="tp_nama")
	private String tpNama;
	
	@Column(name="return_year")
	private int returnYear;
	
	@Column(name="return_persen_year")
	private int returnPersenYear;
	
	@Column(name="action")
	private String action;
	
	@Column(name="jumlah_invest")
	private Double jumlahInvest;
	
	@Column(name="history_dt")
	private LocalDateTime historyDt;
	
	@Column(name="cre_name")
	private String creName;
	
	public TrxProductDetail() {
		
	}
	
	public TrxProductDetail(int id, String nama, int cId, String cNama, int piId, String piNama, String tpNama,
			int returnYear, int returnPersenYear, String action, Double jumlahInvest, LocalDateTime historyDt,
			String creName) {
		super();
		this.id = id;
		this.nama = nama;
		this.cId = cId;
		this.cNama = cNama;
		this.piId = piId;
		this.piNama = piNama;
		this.tpNama = tpNama;
		this.returnYear = returnYear;
		this.returnPersenYear = returnPersenYear;
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

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcNama() {
		return cNama;
	}

	public void setcNama(String cNama) {
		this.cNama = cNama;
	}

	public int getPiId() {
		return piId;
	}

	public void setPiId(int piId) {
		this.piId = piId;
	}

	public String getPiNama() {
		return piNama;
	}

	public void setPiNama(String piNama) {
		this.piNama = piNama;
	}

	public String getTpNama() {
		return tpNama;
	}

	public void setTpNama(String tpNama) {
		this.tpNama = tpNama;
	}

	public int getReturnYear() {
		return returnYear;
	}

	public void setReturnYear(int returnYear) {
		this.returnYear = returnYear;
	}

	public int getReturnPersenYear() {
		return returnPersenYear;
	}

	public void setReturnPersenYear(int returnPersenYear) {
		this.returnPersenYear = returnPersenYear;
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
	
	
	
	
}
