package com.ql.model;

import java.io.Serializable;

/**
 * Student class
 * 
 * @author viettuts.vn
 */
public class Nhanvien implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private byte age;
    private String address;
    

    public Nhanvien() {
    }

    public Nhanvien(int id, String name, byte age, String address) {
        super();
        this.setId(id);
        this.setName(name);
        this.setAge(age);
        this.setAddress(address);
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

    
}