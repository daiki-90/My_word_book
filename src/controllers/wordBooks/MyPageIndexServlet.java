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

import models.User;
import models.WordBook;
import utils.DBUtil;

/**
 * Servlet implementation class MyPageIndexServlet
 */
@WebServlet("/index.html")
public class MyPageIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        User login_user = (User)request.getSession().getAttribute("login_user");

        int page;
        try{
            page = Integer.parseInt(request.getParameter("page"));
        } catch(Exception e) {
            page = 1;
        }
        List<WordBook> wordBooks = em.createNamedQuery("getAllMyWordBooks", WordBook.class)
                                  .setParameter("user", login_user)
                                  .setFirstResult(10 * (page - 1))
                                  .setMaxResults(10)
                                  .getResultList();


        long wordBooks_count = (long)em.createNamedQuery("getAllMyWordBooksCount", Long.class)
                                     .setParameter("user", login_user)
                                     .getSingleResult();

        em.close();

        request.setAttribute("wordBooks", wordBooks);
        request.setAttribute("wordBooks_count", wordBooks_count);
        request.setAttribute("page", page);
        request.getSession().removeAttribute("word_book");
        request.getSession().removeAttribute("wordBook_id");
        request.getSession().removeAttribute("wordBook");

        if(request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
        }

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/word_books/index.jsp");
        rd.forward(request, response);

    }

}
