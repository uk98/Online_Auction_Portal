import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String custid = request.getParameter("custid");
		String custpass = null;
		try {
			custpass =  HashPwd.toHexString(HashPwd.getSHA((String)request.getParameter("custpass")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		String hash_algo = "SHA-256";
		
		int flag=0;
		try
		{
			Connection conn = DbConnect.dbConnection();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select mail,pwd_hash from acc");
			while(rs.next())
			{
				if(custid.equals("admin@oap.com") && custpass.equals(rs.getString(2)))
				{
					HttpSession hs= request.getSession(true);
					flag=1;
					response.sendRedirect("http://localhost:8080/OnlineAuctionPortal/Homepage.jsp");
					/*st.close();
				conn.close();
				System.exit(0);*/
				}
				if(custid.equals(rs.getString(1)) && custpass.equals(rs.getString(2)))
				{
					HttpSession hs= request.getSession();
					flag=1;
					hs.setAttribute("LOGIN", custid);
					hs.setAttribute("name", rs.getString(2));
					response.sendRedirect("http://localhost:8080/OnlineAuctionPortal/Signup.jsp");
				}
			}	
		} catch (Exception e1) {
			e1.printStackTrace();
		}	
		if(flag==0) {
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Incorrect Login ID/Password');");
			out.println("location='Login.jsp';");
			out.println("</script>");
		}
		
	}
}