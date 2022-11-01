package controller;

import domain.Business;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteBusiness extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        Business b = service.getBusinessbyID(bid);
        request.setAttribute("business", b);
        return "confirm-delete-business.jsp";
    }
}
