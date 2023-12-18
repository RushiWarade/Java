package dao;

import model.Expense;
import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public boolean addUser(User user) {

        boolean msg = false;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int i = (Integer) session.save(user);
        transaction.commit();

        if (i > 0) {
            msg = true;
        }


        return msg;
    }

    public User login(String email, String password) {
        User user = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from user where email=:em and password=:pass ");

        query.setParameter("em", email);
        query.setParameter("pass", password);

        user = (User) query.uniqueResult();

        transaction.commit();


        return user;
    }

    public boolean addExpense(Expense expense) {

        boolean ex = false;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int i = (Integer) session.save(expense);
        transaction.commit();

        if (i > 0) {
            ex = true;
        }
        return ex;
    }


    public List<Expense> expenseList(User user) {
        List<Expense> expenseList = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from expense where user=:user");
        query.setParameter("user", user);

        expenseList = query.list();

        return expenseList;
    }

    public Expense getExpense(int id) {
        Expense expense = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from expense  where id=:id");
        query.setParameter("id", id);

        expense = (Expense) query.uniqueResult();


        return expense;
    }

    public boolean updateExpense(Expense expense) {
        boolean b = false;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
       session.update(expense);
        transaction.commit();
        b=true;
        return b;
    }
}
