package controller;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.DoctorDao;
import to.Doctor;



@ManagedBean(name="regis")
@RequestScoped
public class RegistroServlet {
	
	private String nombre;
	private String edad;
	private String especialidad;
	private String sexo;
	private String rfc;
	private String email;
	private String password;
	
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEdad() {
		return edad;
	}


	public void setEdad(String edad) {
		this.edad = edad;
	}


	public String getEspecialidad() {
		return especialidad;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getRfc() {
		return rfc;
	}


	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void doGet(){
		
		
		//recuperar_parametros
		String nombre = this.nombre;
		String edad = this.edad;
		String especialidad = this.especialidad;
		String sexo = this.sexo;
		String rfc = this.rfc;
		String email = this.email;
		String password = this.password;

		//instancia_de_la_clase_operacion
		//Operacion operacion = new Operacion();
		
		
		try{
			if(!nombre.equals("") && !email.equals("") && !password.equals("")){
				
				
				
				DoctorDao docC = new DoctorDao();
				nombre = nombre.toUpperCase();
				System.out.println("sin con " + edad);
				edad = Integer.toString(Integer.parseInt(edad));
				System.out.println("convertido " + edad);
				edad = edad.toUpperCase();
				especialidad = especialidad.toUpperCase();
				sexo = sexo.toUpperCase();
				rfc = rfc.toUpperCase();
				email = email.toUpperCase();
				password = password.toUpperCase();
				System.out.println("toupercase "+ nombre);
				Doctor doctor = new Doctor(nombre, edad, especialidad, sexo, rfc, email, password);
				docC.create(doctor);
				System.out.println("impresion desde registro");
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro guardado!", "Tu cuenta ha sido creado con nombre: "+nombre));
				
				}else{
					System.out.println("nombre esta vacio");
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Campo obligatorio", "Debes de rellenar los campos obligatorios, correctamente"));
				}
			
		}catch(NullPointerException e)
        {
            System.out.print("NullPointerException caught");
        }
		
		
	}
	

}
