package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import to.Doctor;
import to.Horario;

public class HorarioDao implements IHorarioDao {
	private DataSource ds;
	private Horario horario;
	
	
	public HorarioDao() {
		ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public void create(Horario horario) {
		// TODO Auto-generated method stub
		
		//(dias, horarioInicio, horarioFin, semana, idDoctor, idHorario)	
		String sql = "insert into horario (dias, hora_inicio, hora_fin, semana, idDoctor, idHorario) "
				+ "values (?, ?, ?, ?, ?, ?)";

			
		Connection con = null;
		try {
			con = ds.getConnection();
			
			if (con == null)
				throw new SQLException("Can't get database connection");

			//System.out.println("llega hasta horario DAo");
			PreparedStatement ps = con.prepareStatement(sql);
			//System.out.println("insert nombre " + horario.getDias());
			ps.setString(1, horario.getDias());
			ps.setString(2, horario.getHorarioInicio());
			ps.setString(3, horario.getHorarioFin());
			ps.setString(4, horario.getSemana());
			ps.setString(5, horario.getIdDoctor());
			ps.setString(6, horario.getIdHorario());

			System.out.println(sql);
			ResultSet result = ps.executeQuery();
			System.out.println("Registro Guardado");
			FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro guardado!", "Tu horario, ha sido guardado."));
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {

				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
	}

}
