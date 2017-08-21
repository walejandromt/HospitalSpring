package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.HorarioDao;
import to.Horario;

@ManagedBean(name="horario")
@RequestScoped
public class HorarioBeans {
	private String idHorario;
	private String semana;
	private String idDoctor;
	
	private boolean lunes;
	private boolean martes;
	private boolean miercoles;
	private boolean jueves;
	private boolean viernes;

	private String lunesI;
	private String lunesF;
	
	private String martesI;
	private String martesF;
	
	private String miercolesI;
	private String miercolesF;
	
	private String juevesI;
	private String juevesF;
	
	private String viernesI;
	private String viernesF;

	
	
public void doGet(){

		//instancia_de_la_clase_operacion
		//Operacion operacion = new Operacion();
		
	//(dias, horarioInicio, horarioFin, semana, idDoctor, idHorario)		
		try{
			if(lunes){
				
				if(!lunesI.equals("") || !lunesF.equals("")){
					HorarioDao hoDao = new HorarioDao();
					Horario horario = new Horario("LUNES", lunesI, lunesF, semana, "01","01");
					
					hoDao.create(horario);
					
				}else{
					System.out.println("nombre esta vacio");
					FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_WARN, "Lunes", "El campo de hora de inicio o fin, no pueden quedar vacio"));
				}
				
				}if(martes){
					
					if(!martesI.equals("") || !martesF.equals("")){
						HorarioDao hoDao = new HorarioDao();
						Horario horario = new Horario("MARTES", martesI, martesF, semana, "01","01");
						
						hoDao.create(horario);
						
						
					}else{
						System.out.println("nombre esta vacio");
						FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_WARN, "Martes", "El campo de hora de inicio o fin, no pueden quedar vacio"));
					}
					
					
					
				}if(miercoles){
					
					if(!miercolesI.equals("") || !miercolesF.equals("")){
						
						HorarioDao hoDao = new HorarioDao();
						Horario horario = new Horario("MIERCOLES", miercolesI, miercolesF, semana, "01","01");
						
						hoDao.create(horario);
						
						
					}else{
						System.out.println("nombre esta vacio");
						FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_WARN, "Miercoles", "El campo de hora de inicio o fin, no pueden quedar vacio"));
					}
					
					
					
				}if(jueves){
					
					if(!juevesI.equals("") || !juevesF.equals("")){
						
						HorarioDao hoDao = new HorarioDao();
						Horario horario = new Horario("JUEVES", juevesI, juevesF, semana, "01","01");
						
						hoDao.create(horario);
						
						
					}else{
						System.out.println("nombre esta vacio");
						FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_WARN, "Jueves", "El campo de hora de inicio o fin, no pueden quedar vacio"));
					}
					
					
					
				}if(viernes){
					
					if(!viernesI.equals("") || !viernesF.equals("")){
						
						HorarioDao hoDao = new HorarioDao();
						Horario horario = new Horario("VIERNES", viernesI, viernesF, semana, "01","01");
						
						hoDao.create(horario);
						

						
					}else{
						System.out.println("nombre esta vacio");
						FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_WARN, "Viernes", "El campo de hora de inicio o fin, no pueden quedar vacio"));
					}
					
										
				}else if(!lunes && !martes && !miercoles && !jueves && !viernes){
					System.out.println("seleciona un dia");
					FacesContext.getCurrentInstance().addMessage("msghor", new FacesMessage(FacesMessage.SEVERITY_FATAL, "Lo sentimos", "Para registrar un horario es necesario selecionar un dia."));
									
				}
			
		}catch(NullPointerException e)
        {
			
            System.out.print("NullPointerException caught");
        }
		
		
	}



public String getIdHorario() {
	return idHorario;
}



public void setIdHorario(String idHorario) {
	this.idHorario = idHorario;
}



public String getIdDoctor() {
	return idDoctor;
}



public void setIdDoctor(String idDoctor) {
	this.idDoctor = idDoctor;
}



public String getLunesI() {
	return lunesI;
}



public void setLunesI(String lunesI) {
	this.lunesI = lunesI;
}



public String getLunesF() {
	return lunesF;
}



public void setLunesF(String lunesF) {
	this.lunesF = lunesF;
}



public boolean isLunes() {
	return lunes;
}



public void setLunes(boolean lunes) {
	this.lunes = lunes;
}



public String getSemana() {
	return semana;
}



public void setSemana(String semana) {
	this.semana = semana;
}



public boolean isMartes() {
	return martes;
}



public void setMartes(boolean martes) {
	this.martes = martes;
}



public boolean isMiercoles() {
	return miercoles;
}



public void setMiercoles(boolean miercoles) {
	this.miercoles = miercoles;
}



public boolean isJueves() {
	return jueves;
}



public void setJueves(boolean jueves) {
	this.jueves = jueves;
}



public boolean isViernes() {
	return viernes;
}



public void setViernes(boolean viernes) {
	this.viernes = viernes;
}



public String getMartesI() {
	return martesI;
}



public void setMartesI(String martesI) {
	this.martesI = martesI;
}



public String getMartesF() {
	return martesF;
}



public void setMartesF(String martesF) {
	this.martesF = martesF;
}



public String getMiercolesI() {
	return miercolesI;
}



public void setMiercolesI(String miercolesI) {
	this.miercolesI = miercolesI;
}



public String getMiercolesF() {
	return miercolesF;
}



public void setMiercolesF(String miercolesF) {
	this.miercolesF = miercolesF;
}



public String getJuevesI() {
	return juevesI;
}



public void setJuevesI(String juevesI) {
	this.juevesI = juevesI;
}



public String getJuevesF() {
	return juevesF;
}



public void setJuevesF(String juevesF) {
	this.juevesF = juevesF;
}



public String getViernesI() {
	return viernesI;
}



public void setViernesI(String viernesI) {
	this.viernesI = viernesI;
}



public String getViernesF() {
	return viernesF;
}



public void setViernesF(String viernesF) {
	this.viernesF = viernesF;
}
	
	
	

}
