package daoo;

import java.util.List;

import metier.entities.Departement;

public interface IDepartementDAO {
	public Departement save(Departement p);
	public List<Departement> DepartementParMC(String mc);
	public Departement getDepartement(Long id);
	public Departement updateDepartement(Departement p);
	public void deleteDepartement(Long id);
}


