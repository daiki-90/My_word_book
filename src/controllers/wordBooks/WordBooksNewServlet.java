package controllers.wordBooks;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.WordBook;

/**
 * Servlet implementation class WordBooksNewServlet
 */
@WebServlet("/word_books/new")
public class WordBooksNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        WordBook w = new WordBook();
        w.setWordBook_date(new Date(System.currentTimeMillis()));
        request.setAttribute("report", w);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_books/new.jsp");
        rd.forward(request, response);

    }

}
