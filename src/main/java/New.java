import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/New")
public class New extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountholder = request.getParameter("accountholder");
        String secretpassword = request.getParameter("secretpassword");
        String amountStr = request.getParameter("initialAmount");

        // Generate account number
        String accountnumber = "AC" + (int)(Math.random() * 1000000000);

        // Default to 0.0 if no amount entered
        double balance = 0.0;
        if (amountStr != null && !amountStr.isEmpty()) {
            balance = Double.parseDouble(amountStr);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/log2", "root", "1234");

            String sql = "INSERT INTO accounts (accountnumber, accountholder, secretpassword, balance) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, accountnumber);
            stmt.setString(2, accountholder);
            stmt.setString(3, secretpassword);
            stmt.setDouble(4, balance);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                out.println("<h3>Account Created Successfully!</h3>");
                out.println("<p>Account Number: <strong>" + accountnumber + "</strong></p>");
                out.println("<p>Initial Balance: ₹" + balance + "</p>");
                response.setHeader("Refresh", "5; URL=Thank.jsp");
            } else {
                out.println("<h3>Account creation failed.</h3>");
            }

            stmt.close();
            conn.close();

        } catch (Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            e.printStackTrace(out);
        }
    }
}
