package controllers.wordBooks;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.User;
import models.WordBook;
import utils.DBUtil;

/**
 * Servlet implementation class WordBooksEditServlet
 */
@WebServlet("/word_books/edit")
public class WordBooksEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordBooksEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        WordBook w = em.find(WordBook.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        User login_user = (User)request.getSession().getAttribute("login_user");
        if(w != null && login_user.getId() == w.getUser().getId()) {
            request.setAttribute("wordBook", w);
            request.setAttribute("_token", request.getSession().getId());
            request.getSession().setAttribute("wordBook_id", w.getId());
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_books/edit.jsp");
        rd.forward(request, response);

    }

}
