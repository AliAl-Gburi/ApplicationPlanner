package controller;

import services.AppService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    protected AppService service;

    public abstract String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException;

    public AppService getService() {
        return service;
    }

    public void setService(AppService service) {
        this.service = service;
    }
}
