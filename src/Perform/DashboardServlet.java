package Perform;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EoCheck
 */
@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			if (!username.equals("a") || !password.equals("a")) {
				response.sendRedirect("index.html");
			} else {
//				response.sendRedirect("dashboard.html");
				
//				response.sendRedirect("dashboard.jsp");
				
				List<Student> students = new ArrayList<>(Arrays.asList(
					new Student("S1", "Tucker", "Dep 1", 35),
					new Student("S2", "Minnie", "Dep 1", 70),
					new Student("S3", "Phil", "Dep 1", 60),
					new Student("S4", "Avery", "Dep 1", 90),
					new Student("S5", "Sid", "Dep 2", 30),
					new Student("S6", "Hannah", "Dep 3", 32),
					new Student("S7", "Ivy", "Dep 3", 72),
					new Student("S8", "Erica", "Dep 3", 20)
				));
				request.setAttribute("username", username);
				request.setAttribute("students", students);
				
		        Map<String, Double> departmentPass = new HashMap<>();
		        Map<String, Integer> departmentCount = new HashMap<>();
		        for (Student n : students) {
		            String department = n.getDepartment();
		            double mark = n.getMark();

		            departmentPass.putIfAbsent(department, 0.0);
		            departmentCount.putIfAbsent(department, 0);

		            if (mark >= 40) departmentPass.put(department, departmentPass.get(department) + 1);
		            departmentCount.put(department, departmentCount.get(department) + 1);
		        }
		        for (String n : departmentPass.keySet()) {
		            double sum = departmentPass.get(n);
		            int count = departmentCount.get(n);
		            double percentage = count > 0 ? Math.round((sum / count) * 10000) / 100.0 : 0.0;
		            departmentPass.put(n, percentage);
		        }
		        for (Student n : students) {
		        	n.setPass(departmentPass.get(n.getDepartment()));
		        }

				RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
				rd.forward(request, response);
				
				
//				
//				out.println("<p>Welcome, " + username + ".</p>");
//				out.println("<table>");
//				out.println("<thead><tr>");
//				out.println("<td>Deparment</td>");
//				out.println("<td>Student ID</td>");
//				out.println("<td>Marks</td>");
//				out.println("<td>Pass %</td>");
//				out.println("</tr></thead>");
//				out.println("<tbody>");
//				for (Student n : students) {
//					out.println("<tr>");
//					out.println("<td>" + n.department + "</td>");
//					out.println("<td><a href='#'>" + n.studentId + "<a></td>");
//					out.println("<td>" + n.mark + "</td>");
//					out.println("<td>Pass %</td>");
//					out.println("</tr>");
//				}
//				out.println("</tbody>");
//				out.println("</table>");
			}
		} catch (Exception e) {
			out.println("Error: " + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

//	private 
}
