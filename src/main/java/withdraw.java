import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/log2", "root", "1234");

            // 1. Verify account and password
            String query = "SELECT balance FROM accounts WHERE accountnumber = ? AND accountholder = ? AND secretpassword = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountnumber);
            stmt.setString(2, accountholder);
            stmt.setString(3, secretpassword);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");

                if (currentBalance >= amount) {
                    // 2. Proceed with withdrawal
                    String update = "UPDATE accounts SET balance = balance - ? WHERE accountnumber = ?";
                    PreparedStatement updateStmt = conn.prepareStatement(update);
                    updateStmt.setDouble(1, amount);
                    updateStmt.setString(2, accountnumber);

                    int updated = updateStmt.executeUpdate();

                    if (updated > 0) {
                        out.println("<h3>Withdrawal Successful!</h3>");
                        out.println("<p>₹" + amount + " withdrawn from account <strong>" + accountnumber + "</strong></p>");
                    } else {
                        out.println("<h3>Error processing withdrawal.</h3>");
                    }

                    updateStmt.close();
                } else {
                    out.println("<h3>Insufficient Balance.</h3>");
                }

            } else {
                out.println("<h3>Account Not Found or Wrong Password.</h3>");
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
