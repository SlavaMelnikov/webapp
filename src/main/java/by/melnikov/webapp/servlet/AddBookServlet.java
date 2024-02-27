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

import static by.melnikov.webapp.util.PagePaths.ALL_BOOKS;

@WebServlet(name = "addBookServlet", urlPatterns = "/add-book-servlet")
public class AddBookServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String authorFirstName = request.getParameter("authorFirstName");
        String authorLastName = request.getParameter("authorLastName");
        Author author = new Author(authorFirstName, authorLastName);
        int authorId = AuthorServiceImpl.INSTANCE.addAuthor(author);
        author.setAuthorId(authorId);
        int price = Integer.parseInt(request.getParameter("price"));
        String title = request.getParameter("title");
        Book book = new Book(title, author, price);
        BookServiceImpl.INSTANCE.addBook(book);
        List<Book> listOfBooks = BookServiceImpl.INSTANCE.findAllBooks();
        request.setAttribute("listOfBooks", listOfBooks);
        request.getRequestDispatcher(ALL_BOOKS).forward(request, response);
    }
}
