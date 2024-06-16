package com.example.demo.dto;

public class User {

	private Long id;
	private String nombre;
	private String apellidos;
	private Long telefono;
	private String mail;
	private String direccion;

	private static Long idActU = 0L;

	public User(String firstName, String lastName, Long phone, String mail, String address) {
		this.id = ++idActU;
		this.nombre = firstName;
		this.apellidos = lastName;
		this.telefono = phone;
		this.mail = mail;
		this.direccion = address;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return nombre;
	}

	public void setFirstName(String firstName) {
		this.nombre = firstName;
	}

	public String getLastName() {
		return apellidos;
	}

	public void setLastName(String lastName) {
		this.apellidos = lastName;
	}

	public Long getPhone() {
		return telefono;
	}

	public void setPhone(Long phone) {
		this.telefono = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return direccion;
	}

	public void setAddress(String address) {
		this.direccion = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", mail="
				+ mail + ", direccion=" + direccion + "]";
	}

}
