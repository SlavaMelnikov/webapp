package by.melnikov.webapp.servlet;

import by.melnikov.webapp.entity.Book;
import by.melnikov.webapp.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.melnikov.webapp.util.PagePaths.ALL_BOOKS;

@WebServlet(name = "deleteBook", urlPatterns = "/delete-book")
public class DeleteBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookId = request.getParameter("bookId");
        BookServiceImpl.INSTANCE.removeBookById(Integer.parseInt(bookId));
        List<Book> listOfBooks = BookServiceImpl.INSTANCE.findAllBooks();
        request.setAttribute("listOfBooks", listOfBooks);
        request.getRequestDispatcher(ALL_BOOKS).forward(request, response);
    }
}
