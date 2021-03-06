package controllers.words;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;
import utils.DBUtil;

/**
 * Servlet implementation class WordsDestroyServlet
 */
@WebServlet("/words/destroy")
public class WordsDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Integer wordBook_id = (Integer)request.getSession().getAttribute("wordBook_id");
            Word w = em.find(Word.class, (Integer)(request.getSession().getAttribute("word_id")));

            em.getTransaction().begin();
            em.remove(w);       // データ削除
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("word_id");

            response.sendRedirect(request.getContextPath() + "/word_books/show?id=" + wordBook_id);
        }

    }

}
