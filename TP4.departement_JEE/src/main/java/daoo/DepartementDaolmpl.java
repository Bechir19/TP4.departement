package daoo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import metier.entities.SingletonConnection;
import metier.entities.Departement;
public class DepartementDaolmpl implements IDepartementDAO {
@Override
public Departement save(Departement p) {
Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("INSERT INTO Departement (NOM_departement,Nb_employee) VALUES(?,?)");
ps.setString(1, p.getNOM_departement());
ps.setDouble(2, p.getNb_employee());
ps.executeUpdate();
PreparedStatement ps2= conn.prepareStatement("SELECT MAX(ID_departement) as MAX_ID FROM Departement");
ResultSet rs =ps2.executeQuery();
if (rs.next()) {
p.setID_departement(rs.getLong("MAX_ID"));
}
ps.close();
ps2.close();
} catch (SQLException e) {
e.printStackTrace();
}
return p;
}
public List<Departement> DepartementParMC(String mc) {
 List<Departement> prods= new ArrayList<Departement>();
 Connection conn=SingletonConnection.getConnection();
 try {
PreparedStatement ps= conn.prepareStatement("select * from Departement where NOM_departement LIKE ?");
ps.setString(1, "%"+mc+"%");
ResultSet rs = ps.executeQuery();
while (rs.next()) {
Departement p = new Departement();
p.setID_departement(rs.getLong("ID_departement"));
p.setNOM_departement(rs.getString("NOM_departement"));
p.setNb_employee(rs.getInt("Nb_employee"));
prods.add(p);
}
} catch (SQLException e) {
e.printStackTrace();
}
return prods;
}
@Override
public Departement getDepartement(Long id) {
	Connection conn=SingletonConnection.getConnection();
	 Departement p = new Departement();
	 try {
	PreparedStatement ps= conn.prepareStatement("select * from Departement where ID_departement = ?");
	ps.setLong(1, id);
	ResultSet rs = ps.executeQuery();
	if (rs.next()) {
	p.setID_departement(rs.getLong("ID_departement"));
	p.setNOM_departement(rs.getString("NOM_departement"));
	p.setNb_employee(rs.getInt("Nb_employee"));
	}
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
}
@Override
public Departement updateDepartement(Departement p) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("UPDATE Departement SET NOM_departement=?,Nb_employee=? WHERE ID_departement=?");
	ps.setString(1, p.getNOM_departement());
	ps.setDouble(2, p.getNb_employee());
	ps.setLong(3, p.getID_departement());
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return p;
}
@Override
public void deleteDepartement(Long id) {
	Connection conn=SingletonConnection.getConnection();
	 try {
	PreparedStatement ps= conn.prepareStatement("DELETE FROM  Departement WHERE ID_departement = ?");
	ps.setLong(1, id);
	ps.executeUpdate();
	ps.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}

	
}





}