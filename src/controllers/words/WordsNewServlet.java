package controllers.words;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;

/**
 * Servlet implementation class WordsNewServlet
 */
@WebServlet("/words/new")
public class WordsNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer wordBook_id = Integer.parseInt(request.getParameter("id"));

        request.setAttribute("_token", request.getSession().getId());

        Word w = new Word();
        request.setAttribute("word", w);
        request.setAttribute("wordBook_id", wordBook_id);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/words/new.jsp");
        rd.forward(request, response);

    }

}
