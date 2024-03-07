package metier.entities;

import java.io.Serializable;

public class Departement implements Serializable{
	
	private Long ID_departement;
	private String NOM_departement;
	private int Nb_employee;
	public Departement()
	{
	}
	public Departement(String NOM_departement, int Nb_employee) {
	
	this.NOM_departement = NOM_departement;
	this.Nb_employee = Nb_employee;
	}
	
	public Long getID_departement() {
		return ID_departement;
	}
	public void setID_departement(Long iD_departement) {
		ID_departement = iD_departement;
	}
	public String getNOM_departement() {
		return NOM_departement;
	}
	public void setNOM_departement(String nOM_departement) {
		NOM_departement = nOM_departement;
	}
	public double getNb_employee() {
		return Nb_employee;
	}
	public void setNb_employee(int nb_employee) {
		Nb_employee = nb_employee;
	}
}
	