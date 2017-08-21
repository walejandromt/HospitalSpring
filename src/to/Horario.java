package to;

public class Horario {
	private String idHorario;
	private String dias;
	private String horarioInicio;
	private String horarioFin;
	private String semana;
	private String idDoctor;
	
	
	
	
	public Horario() {
		
	}
	public Horario(String dias, String horarioInicio, String horarioFin, String semana,
			String idDoctor, String idHorario) {
		super();
		this.idHorario = idHorario;
		this.dias = dias;
		this.horarioInicio = horarioInicio;
		this.horarioFin = horarioFin;
		this.semana = semana;
		this.idDoctor = idDoctor;
	}
	public String getIdHorario() {
		return idHorario;
	}
	public void setIdHorario(String idHorario) {
		this.idHorario = idHorario;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public String getHorarioInicio() {
		return horarioInicio;
	}
	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFin() {
		return horarioFin;
	}
	public void setHorarioFin(String horarioFin) {
		this.horarioFin = horarioFin;
	}
	public String getSemana() {
		return semana;
	}
	public void setSemana(String semana) {
		this.semana = semana;
	}
	public String getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(String idDoctor) {
		this.idDoctor = idDoctor;
	}
	
	

}
