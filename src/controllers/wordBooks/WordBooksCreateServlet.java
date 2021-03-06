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

import models.User;
import models.WordBook;
import models.validators.WordBookValidator;
import utils.DBUtil;

/**
 * Servlet implementation class WordBooksCreateServlet
 */
@WebServlet("/word_books/create")
public class WordBooksCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksCreateServlet() {
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

        WordBook w = new WordBook();

        w.setUser((User)request.getSession().getAttribute("login_user"));

        Date wordBook_date = new Date(System.currentTimeMillis());
        String rd_str = request.getParameter("wordBook_date");
        if(rd_str != null && !rd_str.equals("")) {
            wordBook_date = Date.valueOf(request.getParameter("wordBook_date"));
        }
        w.setWordBook_date(wordBook_date);

        w.setTitle(request.getParameter("title"));
        w.setComment(request.getParameter("comment"));


        List<String> errors = WordBookValidator.validate(w);
        if(errors.size() > 0) {
            em.close();

            request.setAttribute("_token", request.getSession().getId());
            request.setAttribute("report", w);
            request.setAttribute("errors", errors);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_books/new.jsp");
            rd.forward(request, response);
        } else {
            em.getTransaction().begin();
            em.persist(w);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/");
        }
      }
    }
}
