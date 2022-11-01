package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.IOException;

public class UploadPhoto extends RequestHandler{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String filename = "";
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        for (Part part : request.getParts()) {
            String path = "C:/Users/aliam/OneDrive/Documents/ApplicationPlanner/src/main/webapp/profilepics/";
            filename = user.getUserid() + ".jpg";

            part.write(path + filename);
            String full = path+filename;
            System.out.println("XD");

            service.updateProfilePic(user.getUserid(), full);

        }
        User us = service.getUserByUserid(user.getUserid());
        session.setAttribute("user", us);

        return "Controller?command=ProfilePage";
    }
}
