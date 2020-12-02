package controllers.wordBooks;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.WordBook;
import models.validators.WordBookValidator;
import utils.DBUtil;

/**
 * Servlet implementation class WordBooksUpdateServlet
 */
@WebServlet("/word_books/update")
public class WordBooksUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksUpdateServlet() {
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

            w.setWordBook_date(Date.valueOf(request.getParameter("wordBook_date")));
            w.setTitle(request.getParameter("title"));
            w.setComment(request.getParameter("comment"));

            List<String> errors = WordBookValidator.validate(w);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("wordBook", w);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_book/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();

                request.getSession().removeAttribute("wordBook_id");

                response.sendRedirect(request.getContextPath() + "/");
            }
        }
    }

}
