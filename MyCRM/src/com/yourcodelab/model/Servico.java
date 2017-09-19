package com.yourcodelab.model;

public class Servico {
	private Integer id;
	private String serial;
	private String data;
	private String hora;
	private String descricaodefeito;
	private Float valorconserto;
	private String status;
	
	public Servico(Integer id , String serial , String data , String hora , 
			String descricaodefeito , Float valorconserto , String status){
		this.id = id;
		this.serial = serial;
		this.data = data;
		this.hora = hora;
		this.descricaodefeito = descricaodefeito;
		this.valorconserto = valorconserto;
		this.status = status;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getDescricaodefeito() {
		return descricaodefeito;
	}
	public void setDescricaodefeito(String descricaodefeito) {
		this.descricaodefeito = descricaodefeito;
	}
	public Float getValorconserto() {
		return valorconserto;
	}
	public void setValorconserto(Float valorconserto) {
		this.valorconserto = valorconserto;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
