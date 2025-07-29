import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Validation")
public class Validation extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String jdbcURL = "jdbc:mysql://localhost:3306/log2?useSSL=false&serverTimezone=UTC";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");      
        String contact = request.getParameter("contact"); 
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

            if (name != null && contact != null) {
               
                String insertSQL = "INSERT INTO users (name, contact, email, password) VALUES (?, ?, ?, ?)";
                PreparedStatement insertStmt = conn.prepareStatement(insertSQL);
                insertStmt.setString(1, name);
                insertStmt.setString(2, contact);
                insertStmt.setString(3, email);
                insertStmt.setString(4, password);

                int rows = insertStmt.executeUpdate();
                insertStmt.close();
                conn.close();

                if (rows > 0) {
                    out.println("<html><head>");
                    out.println("<meta http-equiv='refresh' content='2;URL=index.jsp'>"); 
                    out.println("</head><body>");
                    out.println("<h2 style='text-align:center; color:green;'>Registration Successful! Redirecting to login...</h2>");
                    out.println("</body></html>");
                } else {
                    out.println("<h2 style='color:red; text-align:center;'>Registration failed. Try again.</h2>");
                }

            } else {
                // LOGIN BLOCK
                String loginSQL = "SELECT * FROM users WHERE email = ? AND password = ?";
                PreparedStatement loginStmt = conn.prepareStatement(loginSQL);
                loginStmt.setString(1, email);
                loginStmt.setString(2, password);

                ResultSet rs = loginStmt.executeQuery();

                if (rs.next()) {
                    out.println("<html><head>");
                    out.println("<meta http-equiv='refresh' content='2;URL=redirect.jsp'>"); 
                    out.println("</head><body>");
                    out.println("<h2 style='text-align:center; color:green;'>Login Successful! Redirecting...</h2>");
                    out.println("</body></html>");
                } else {
                    out.println("<h2 style='color:red; text-align:center;'>Invalid email or password.</h2>");
                }

                rs.close();
                loginStmt.close();
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2 style='color:red; text-align:center;'>Error: " + e.getMessage() + "</h2>");
        }
    }
}
