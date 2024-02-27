package by.melnikov.webapp.servlet;

import java.io.*;
import java.util.List;

import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import static by.melnikov.webapp.util.PagePaths.ALL_BOOKS;

@WebServlet(name = "booksServlet", urlPatterns = "/books-servlet")
public class BooksListServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<Book> listOfBooks = BookServiceImpl.INSTANCE.findAllBooks();
        request.setAttribute("listOfBooks", listOfBooks);
        request.getRequestDispatcher(ALL_BOOKS).forward(request, response);
    }
}
