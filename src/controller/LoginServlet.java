package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.DoctorDao;
import fechaMX.*;
//import model.Operacion;
import to.Doctor;

@ManagedBean(name="serv")
@SessionScoped
public class LoginServlet {
	
	public Doctor getDocs() {
		return docs;
	}

	public void setDocs(Doctor docs) {
		this.docs = docs;
	}

	private String email;
	private String password;
	private Doctor docs;
	private String resultados;
	private String fecha;
	private String nombre;
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getResultados() {
		System.out.println(resultados + " que es?");
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
	}

	public String getResult(){
		//System.out.println(docs.getNombre());
		return docs.getNombre();
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

	public String doGet(){
		
		boolean val = false;
		
		  Calendar cal1 = Calendar.getInstance();
		   Dias di = new Dias();
		    LocalDateTime a = LocalDateTime.now();
		    
		    System.out.println(a.now().getHour());
		

	     //display time and date using toString()
		// System.out.printf("%s %tB %<te, %<tY", "Due date:", date.toString());
		  
		fecha = "" + ""+a.now().getDayOfMonth()+" de "+di.coMes(a.now().getMonthValue())
	    +"del "+a.now().getYear()+" a las "+a.now().getHour()+":"+a.now().getMinute()+" Hrs";
	    
	    
		System.out.println("impresion desde SumaServlet");
		
		//recuperar_parametros
		String email = this.email;
		String password = this.password;
		
		email = email.toUpperCase();
		password = password.toUpperCase();
		
		//System.out.println("toupercase email"+ email + " " + password.toUpperCase());
		//instancia_de_la_clase_operacion
		//Operacion operacion = new Operacion();
		Doctor doc = new Doctor(email,password);
		
		DoctorDao daos = new DoctorDao();
		
		try{
			
			val = daos.buscar(email, password);
			
			
		}catch(NullPointerException e)
        {
			System.out.println("excepsion en loginservlet");
			
            System.out.print("NullPointerException caught");
            
        }
		
		
		
		//System.out.println("holaServlet "+doc.getEmail());
		if(val){
			doc = daos.getDocs();
			resultados = "entrar";
			//responde = doc.getNombre();
			nombre = doc.getNombre();
			//request.setAttribute("r", responde);
			//RequestDispatcher rd = getServletContext().getRequestDispatcher("/bienvenida.jsp");
		//	rd.forward(request, response);
			//FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
			FacesContext.getCurrentInstance().addMessage("bienvenido", new FacesMessage(FacesMessage.SEVERITY_INFO, "Bievenido", "Bievenido a tu cuenta "+doc.getNombre()));
			System.out.println("si esta en la lista");
		}else{
			
			
			resultados="null";
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Hey!", "Usuario o Contraseña incorrecta."));
	      
	        
		//	request.setAttribute("r", responde);
		//	RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			//rd.forward(request, response);
			System.out.println("NO esta en la lista");
		}
		//int total = operacion.suma(Integer.parseInt(num1), Integer.parseInt(num2));
		
		return resultados;
		
	}
	
	   public void saveMessage() {
	        FacesContext context = FacesContext.getCurrentInstance();
	         
	        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + "holaaa") );
	        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
	    }
	   
	    public String logout() {
	        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	        return "logout";
	    }
	

}
