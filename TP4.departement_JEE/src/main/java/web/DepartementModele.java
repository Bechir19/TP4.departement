package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Departement;
import metier.entities.Departement;
public class DepartementModele {
private String motCle;
List<Departement> departements = new ArrayList<>();
public String getMotCle() {
return motCle;
}
public void setMotCle(String motCle) {
this.motCle = motCle;
}
public List<Departement> getDepartements() {
return departements;
}
public void setDepartement(List<Departement> produits) {
this.departements = produits;
}
}