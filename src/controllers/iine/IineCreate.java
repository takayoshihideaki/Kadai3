package controllers.iine;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import models.Iine;
import models.Report;
import utils.DBUtil;

/**
 * Servlet implementation class IineCreate
 */
@WebServlet("/IineCreate")
public class IineCreate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public IineCreate() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

         EntityTransaction tx = em.getTransaction();

        tx.begin();

        Report i = em.find(Report.class,Integer.parseInt(request.getParameter("report_id")));
        Employee m = em.find(Employee.class,Integer.parseInt(request.getParameter("employee_id")));


        Iine ii = new Iine();


        ii.setReport(i);
        ii.setEmployee(m);


        em.persist(ii);

        tx.commit();

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/iine.jsp");
        rd.forward(request, response);
    }

}
