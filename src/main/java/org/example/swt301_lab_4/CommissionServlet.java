package org.example.swt301_lab_4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "commissionServlet", value = "/commission")
public class CommissionServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String serviceParam = request.getParameter("service");
        String resultMsg = "";
        String errorMsg = "";
        if (serviceParam != null && serviceParam.equals("calculate")) {
            boolean isSalaried = request.getParameter("isSalaried").equals("true");
            String itemType = request.getParameter("itemType");
            boolean isRegularCustomer = request.getParameter("isRegularCustomer").equals("true");
            String rawItemPrice = request.getParameter("itemPrice");
            double itemPrice = Double.parseDouble(rawItemPrice);
            try {
                double result = CommissionCalculator.calculateCommission(isSalaried, isRegularCustomer, itemType, itemPrice);
                log(String.valueOf(result));
                resultMsg = String.format("Commission: %f", result);
                errorMsg = "";
            } catch (IllegalArgumentException ex) {
                resultMsg = "";
                errorMsg = ex.getMessage();
            }
            request.setAttribute("resultMsg", resultMsg);
            request.setAttribute("errorMsg", errorMsg);
            log(resultMsg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }
        request.setAttribute("resultMsg", resultMsg);
        request.setAttribute("errorMsg", errorMsg);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}