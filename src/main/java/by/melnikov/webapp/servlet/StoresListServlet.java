package by.melnikov.webapp.servlet;

import by.melnikov.webapp.entity.Store;
import by.melnikov.webapp.service.impl.StoreServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.melnikov.webapp.util.PagePaths.ALL_STORES;

@WebServlet(name = "storesServlet", urlPatterns = "/stores-servlet")
public class StoresListServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<Store> listOfStores = StoreServiceImpl.INSTANCE.findAllStores();
        request.setAttribute("listOfStores", listOfStores);
        request.getRequestDispatcher(ALL_STORES).forward(request, response);
    }
}
