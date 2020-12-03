package controllers.words;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;
import utils.DBUtil;

/**
 * Servlet implementation class WordsEditServlet
 */
@WebServlet("/words/edit")
public class WordsEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Word w = em.find(Word.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        //WordBook wordBook = (WordBook)request.getSession().getAttribute("wordBook");
        //if(w != null && wordBook.getId() == w.getWordBook().getId()) {
            request.setAttribute("word", w);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("word_id", w.getId());
        //}

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/words/edit.jsp");
        rd.forward(request, response);

    }

}
