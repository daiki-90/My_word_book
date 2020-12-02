package controllers.wordBooks;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.WordBook;
import utils.DBUtil;

/**
 * Servlet implementation class WordBooksDestroyServlet
 */
@WebServlet("/word_books/destroy")
public class WordBooksDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksDestroyServlet() {
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

            WordBook w = em.find(WordBook.class, (Integer)(request.getSession().getAttribute("wordBook_id")));

            em.getTransaction().begin();
            em.remove(w);       // データ削除
            em.getTransaction().commit();
            em.close();

            request.getSession().removeAttribute("wordBook_id");
            request.getSession().setAttribute("flush", "削除が完了しました。");

            response.sendRedirect(request.getContextPath() + "/");
        }

    }

}
