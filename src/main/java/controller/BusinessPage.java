package controller;

import domain.Business;
import domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class BusinessPage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String bid = request.getParameter("bid");
        int bidinteger = Integer.parseInt(bid);
        List<Service> serviceList = service.getServices(bidinteger);
        Business business = service.getBusinessbyID(bidinteger);
        request.setAttribute("services", serviceList);
        request.setAttribute("business", business);
        return "services.jsp";
    }
}
