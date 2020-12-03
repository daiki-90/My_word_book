package controllers.wordBooks;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Word;
import models.WordBook;
import utils.DBUtil;

/**
 * Servlet implementation class WordBooksShowServlet
 */
@WebServlet("/word_books/show")
public class WordBooksShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        Integer wordBook_id = Integer.parseInt(request.getParameter("id"));
        WordBook w = em.find(WordBook.class, Integer.parseInt(request.getParameter("id")));

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        List<Word> words = em.createNamedQuery("getAllWords", Word.class)
                                  .setParameter("wordBook", w)
                                  .setFirstResult(15 * (page - 1))
                                  .setMaxResults(15)
                                  .getResultList();

        long words_count = (long)em.createNamedQuery("getAllWordsCount", Long.class)
                                     .setParameter("wordBook", w)
                                     .getSingleResult();

        em.close();

        request.setAttribute("wordBook", w);
        request.setAttribute("_token", request.getSession().getId());
        request.setAttribute("words", words);
        request.setAttribute("words_count", words_count);
        request.setAttribute("page", page);
        request.getSession().setAttribute("wordBook_id", wordBook_id);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_books/show.jsp");
        rd.forward(request, response);

    }

}
