package controller;

import services.AppService;

import java.lang.reflect.InvocationTargetException;

public class HandlerFactory {
    public RequestHandler getHandler(String command, AppService service) {
        RequestHandler handler = null;
        try {
            Class handlerClass = Class.forName("controller."+command);
            Object objectHandler = handlerClass.getConstructor().newInstance();
            handler = (RequestHandler) objectHandler;
            handler.setService(service);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return handler;
    }
}
