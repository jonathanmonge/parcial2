package com.Controladores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.modelo.Consulta;

import comEntidadesDao.ConsultaDao;


/**
 * Servlet implementation class ServeletConsulta
 */
public class ServeletConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeletConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
Consulta c= new Consulta();
ConsultaDao cli = new ConsultaDao();
		
		String id=null;
		String nombre=null;
		String apellido=null;
		
		
		try {
			
		
		 id= request.getParameter("Id");
		 nombre= request.getParameter("Nombre");
         apellido= request.getParameter("Apellido");
		 
         c.setId(Integer.parseInt(id));
 		c.setNombre(nombre);
 		c.setApellido(apellido);
 		}catch (Exception e) {
			// TODO: handle exception
		}
		String acction= request.getParameter("btn");
		
		if(acction.equals("Guardar Nuevo Registro")) {
			try {
		c.setId(Integer.parseInt(id));
		c.setNombre(nombre);
		c.setApellido(apellido);
			cli.agregarC(c);
			} catch (Exception e) {
				response.sendRedirect("gestionar.jsp");	
			}
		}
			
		
		else if(acction.equals("Guardar Actualizar")) {
			try {
				
			
		c.setId(Integer.parseInt(id));
		c.setNombre(nombre);
		c.setApellido(apellido);
			} catch (Exception e) {
				response.sendRedirect("gestionar.jsp");	
			}
		
		cli.Actualizar(c);
		}
		
		else if(acction.equals("ELIMINAR")) {
			try {
			c.setId(Integer.parseInt(id));
			cli.EliminarC(c);
		} catch (Exception e) {
			response.sendRedirect("gestionar.jsp");	
		}
			
		}
			response.sendRedirect("gestionar.jsp");
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		
ConsultaDao consul=new ConsultaDao();

Gson json= new Gson();
try {
	response.getWriter().append(json.toJson(consul.Consultalista()));
} catch (Exception e) {
	// TODO: handle exception
	System.out.println(e);
	
}

	}

}
