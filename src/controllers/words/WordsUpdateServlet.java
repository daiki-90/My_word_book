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
import models.validators.WordValidator;
import utils.DBUtil;

/**
 * Servlet implementation class WordsUpdateServlet
 */
@WebServlet("/words/update")
public class WordsUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordsUpdateServlet() {
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

            w.setWord(request.getParameter("word"));
            w.setContent(request.getParameter("content"));

            List<String> errors = WordValidator.validate(w);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("word", w);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/words/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

                request.getSession().removeAttribute("word_id");

                response.sendRedirect(request.getContextPath() + "/word_books/show?id=" + wordBook_id);
            }
        }
    }

}
