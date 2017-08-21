package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import to.Doctor;

public class DoctorDao implements IDoctorDao {

	private DataSource ds;
	private Doctor docs;
	
	public Doctor getDocs() {
		return docs;
	}

	public void setDocs(Doctor docs) {
		this.docs = docs;
	}

	public DoctorDao(){
		
		ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void create(Doctor doctor) {
		// TODO Auto-generated method stub
		
		String sql = "insert into doctores (nombre, edad, especialidad, sexo, rfc, email, password) "
				+ "values (?, ?, ?, ?, ?, ?, ?)";
			
		List<Doctor> list = null;
		Connection con = null;
		try {
			con = ds.getConnection();
			if (con == null)
				throw new SQLException("Can't get database connection");

			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("insert nombre " + doctor.getNombre());
			ps.setString(1, doctor.getNombre());
			ps.setString(2, doctor.getEdad());
			ps.setString(3, doctor.getEspecialidad());
			ps.setString(4, doctor.getSexo());
			ps.setString(5, doctor.getRfc());
			ps.setString(6, doctor.getEmail());
			ps.setString(7, doctor.getPassword());
			System.out.println(sql);
			
			
			ResultSet result = ps.executeQuery();
			
		} catch (SQLException e) {
			//System.out.println(x);
			e.printStackTrace();
		} finally {
			try {

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

	@Override
	public void conectar() {
		
			
			ds = null;
			try {
				Context ctx = new InitialContext();
				ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
			} catch (NamingException e) {
				e.printStackTrace();
			}
			
			
		
	}

	
	@Override
	public boolean buscar(String email, String password) {
		boolean val = false;
		String sql = "select * from doctores where email = ? and password = ?";
		
		
		
		Connection con = null;
		try{
			con = ds.getConnection();
			if(con == null)
				throw new SQLException("Can't get database connection");
			
		PreparedStatement ps = con
				.prepareStatement(sql);
		System.out.println("select email " + email);
		ps.setString(1, email);
		ps.setString(2, password);
		System.out.println("select password " + password);
		
		ResultSet result = ps.executeQuery();
		
		
		
		if(result.next()){
			System.out.println("entra al if de buscar");
			docs = new Doctor();
			docs.setNombre(result.getString("nombre"));
			docs.setEdad(result.getString("edad"));
			docs.setEspecialidad(result.getString("especialidad"));
			docs.setSexo(result.getString("sexo"));
			docs.setRfc(result.getString("rfc"));
			docs.setEmail(result.getString("email"));
			docs.setPassword(result.getString("password"));
			val = true;
			
		}else{
			System.out.println("result es igual null");
			val = false;
		}
		
		
		
	}catch(SQLException e){
		
		
		e.printStackTrace();
	}finally{
		try{
			
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
		return val;
		
		
		

		
		}
}
