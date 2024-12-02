package net.jsp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import net.jsp.doa.registerDAO;
import net.jsp.model.student;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String rollno = request.getParameter("rollno");
	    String fname = request.getParameter("fname");
	    String lname = request.getParameter("lname");
	    String DOB = request.getParameter("DOB");

	    try {
	        if (DOB == null || DOB.isEmpty()) {
	            throw new IllegalArgumentException("Date of Birth is required.");
	        }

	        // Convert DOB to LocalDate
	        LocalDate dob = LocalDate.parse(DOB); // Assumes "yyyy-MM-dd" format
	        student s = new student(rollno, fname, lname, dob);

	        registerDAO rdao = new registerDAO();
	        String result = rdao.insert(s);

	        if ("Data Entered Successfully".equals(result)) {
	            response.sendRedirect("success.jsp");
	        } else {
	            response.sendRedirect("error.jsp?message=" + result);
	        }
	    } catch (IllegalArgumentException | DateTimeParseException e) {
	        response.sendRedirect("error.jsp?message=" + e.getMessage());
	    } catch (Exception e) {
	        e.printStackTrace();
	        response.sendRedirect("error.jsp?message=An unexpected error occurred.");
	    }
	}


}
