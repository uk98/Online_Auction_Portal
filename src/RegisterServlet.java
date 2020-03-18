import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Connection conn=null;
		try {
			conn = DbConnect.dbConnection();
		} catch (ClassNotFoundException | SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		PreparedStatement st= null;
		try {
			st = conn.prepareStatement("insert into acc(name,pwd_hash,mno,addr,mail) values(?,?,?,?,?)");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String name =  request.getParameter("name");
		String pwd_hash=null,cpwd_hash=null;
		
		try {
			pwd_hash =  HashPwd.toHexString(HashPwd.getSHA((String)request.getParameter("pwd")));
			cpwd_hash = HashPwd.toHexString(HashPwd.getSHA((String)request.getParameter("cpwd")));
		}
		catch(Exception e) {
			e.printStackTrace();
		}	
		
		String mail = request.getParameter("mail");
		String[] s_mail = mail.split("@");
		
		if(pwd_hash.equals(cpwd_hash) && mail.contains("@") && s_mail[1].contains(".")) {
			try {
				response.setContentType("text/html");
				st.setString(1,name);
				st.setString(2, pwd_hash);
				st.setLong(3, Long.parseLong(request.getParameter("mno")));
				st.setString(4, request.getParameter("addr"));
				st.setString(5, mail);
				st.execute();
				st.close();
				//out.println("<b><center><h1>Record Registered Successfully</br>Redirecting to the login page</h1></center></b>");
				response.sendRedirect("http://localhost:8080/OnlineAuctionPortal/Login.jsp");
			}
			catch(Exception e) {
				out.print(e);
			}
		}			
		else {
			out.println("<b><center><h1>Check Instructions Carefully</h1></center></b>");
			out.println("<b><center>1. Password must be same as confirm password</br>2. E-mail id must be in the format as abc@abc.xyz</center></b>");
			
		}
	}	
}