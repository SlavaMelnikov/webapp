package by.melnikov.webapp.servlet;

import by.melnikov.webapp.entity.Author;
import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.service.impl.AuthorServiceImpl;
import by.melnikov.webapp.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.melnikov.webapp.util.PagePaths.ALL_AUTHORS;
import static by.melnikov.webapp.util.PagePaths.ALL_BOOKS;

@WebServlet(name = "authorsServlet", urlPatterns = "/authors-servlet")
public class AuthorsListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<Author> listOfAuthors = AuthorServiceImpl.INSTANCE.findAllAuthors();
        request.setAttribute("listOfAuthors", listOfAuthors);
        request.getRequestDispatcher(ALL_AUTHORS).forward(request, response);
    }
}
