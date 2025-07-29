import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Balancecheck")
public class Balancecheck extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accountholder = request.getParameter("accountholder");
        String accountnumber = request.getParameter("number");
        String secretpassword = request.getParameter("secretpassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/log2", "root", "1234");

            String query = "SELECT balance FROM accounts WHERE accountnumber = ? AND accountholder = ? AND secretpassword = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountnumber);
            stmt.setString(2, accountholder);
            stmt.setString(3, secretpassword);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                out.println("<h2>Balance Check Successful</h2>");
                out.println("<p>Account Holder: <strong>" + accountholder + "</strong></p>");
                out.println("<p>Account Number: <strong>" + accountnumber + "</strong></p>");
                out.println("<p>Current Balance: ₹<strong>" + balance + "</strong></p>");
            } else {
                out.println("<h3> Invalid credentials or account not found.</h3>");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
}
