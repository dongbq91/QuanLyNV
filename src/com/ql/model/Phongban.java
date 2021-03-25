package com.ql.model;
import java.io.Serializable;
public class Phongban implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPB;
    private String namePB;
    public Phongban() {}
    public Phongban(int idPB, String namePB) {
    	super();
    	this.setIdPB(idPB);
    	this.setNamePB(namePB);
    }
	public int getIdPB() {
		return idPB;
	}
	public void setIdPB(int idPB) {
		this.idPB = idPB;
	}
	public String getNamePB() {
		return namePB;
	}
	public void setNamePB(String namePB) {
		this.namePB = namePB;
	}
}
