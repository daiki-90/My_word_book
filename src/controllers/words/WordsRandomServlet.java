package controllers.words;

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
 * Servlet implementation class WordsRandomServlet
 */
@WebServlet("/words/random")
public class WordsRandomServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsRandomServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();
        // WordBook wordBook  = (WordBook)request.getSession().getAttribute("wordBook");
        WordBook wordBook = em.find(WordBook.class, Integer.parseInt(request.getParameter("id")));


        List<Word> words = em.createNamedQuery("getAllWords", Word.class)
                .setParameter("wordBook", wordBook)
                .getResultList();

        int wordsCount = words.size();

        int target = (int)(Math.random() * wordsCount);

        Word word = words.get(target);

        em.close();

        request.setAttribute("word", word);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/words_random/word.jsp");
        rd.forward(request, response);



    }

}
