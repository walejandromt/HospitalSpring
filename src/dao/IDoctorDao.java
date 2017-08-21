package dao;

import javax.sql.DataSource;

import to.Doctor;

public interface IDoctorDao {
	

	public void create(Doctor doctor);
	public void conectar();
	public boolean buscar(String email, String password);
}
