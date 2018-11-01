/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brightBank.servlet;

import brightBank.jpa.controller.AccountJpaController;
import brightBank.jpa.controller.HistoryJpaController;
import brightBank.jpa.controller.exceptions.NonexistentEntityException;
import brightBank.jpa.controller.exceptions.RollbackFailureException;
import brightBank.model.Account;
import brightBank.model.History;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;

/**
 *
 * @author brightotech
 */
public class WithdrawServlet extends HttpServlet {

    @PersistenceUnit(unitName = "brightBankPU")
    EntityManagerFactory emf;
    @Resource
    UserTransaction utx;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account accountsession = (Account) session.getAttribute("account");
        if (accountsession != null) {
            if (request.getParameter("withdraw") != null) {
                int deposit = Integer.parseInt(request.getParameter("withdraw"));
                AccountJpaController accountCtrl = new AccountJpaController(utx, emf); 
                HistoryJpaController historyCtrl = new HistoryJpaController(utx, emf);                
                Account account = accountCtrl.findAccount(accountsession.getAccountid());
                account.setBalance(account.getBalance() - deposit);
                History history = new History(account, "withdraw", deposit , new Date(),account.getBalance());
                session.setAttribute("account", account);
                session.setAttribute("message", "Withdrawcomplete");
                getServletContext().getRequestDispatcher("/Withdraw.jsp").forward(request, response);
                try {
                    accountCtrl.edit(account);
                    historyCtrl.create(history);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(WithdrawServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (RollbackFailureException ex) {
                    Logger.getLogger(WithdrawServlet.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(WithdrawServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
               session.setAttribute("message", "Plese input money");
                getServletContext().getRequestDispatcher("/Withdraw.jsp").forward(request, response);
            }
        } else {
            getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
