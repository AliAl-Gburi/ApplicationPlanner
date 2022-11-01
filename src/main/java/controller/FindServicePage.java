package controller;

import domain.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FindServicePage extends RequestHandler{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Service> svs = service.getAllServices();
        request.setAttribute("services", svs);
        return "findservice.jsp";
    }
}
