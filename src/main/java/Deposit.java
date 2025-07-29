import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String accountholder = request.getParameter("accountholder");
        String accountnumber = request.getParameter("number");
        String secretpassword = request.getParameter("secretpassword");
        double amount = Double.parseDouble(request.getParameter("amount"));

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // 1. Load MySQL Driver and Connect
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/log2", "root", "1234");

            // 2. Verify account
            String checkQuery = "SELECT balance FROM accounts WHERE accountnumber = ? AND accountholder = ? AND secretpassword = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkQuery);
            checkStmt.setString(1, accountnumber);
            checkStmt.setString(2, accountholder);
            checkStmt.setString(3, secretpassword);

            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                // 3. Update balance
                String updateQuery = "UPDATE accounts SET balance = balance + ? WHERE accountnumber = ?";
                PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
                updateStmt.setDouble(1, amount);
                updateStmt.setString(2, accountnumber);

                int rows = updateStmt.executeUpdate();

                if (rows > 0) {
                    double newBalance = currentBalance + amount;
                    out.println("<h3>Deposit Successful!</h3>");
                    out.println("<p>₹" + amount + " has been added to Account Number: <strong>" + accountnumber + "</strong></p>");
                    out.println("<p>Updated Balance: ₹" + newBalance + "</p>");
                } else {
                    out.println("<h3>Deposit Failed. Please try again.</h3>");
                }

                updateStmt.close();
            } else {
                out.println("<h3>Account not found or incorrect credentials.</h3>");
            }

            rs.close();
            checkStmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
