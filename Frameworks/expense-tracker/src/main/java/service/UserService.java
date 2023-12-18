package service;

import dao.UserDao;
import model.Expense;
import model.User;

import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public User login(String email, String password) {
        return userDao.login(email, password);
    }

    public boolean addExpense(Expense expense) {
        return userDao.addExpense(expense);
    }

    public List<Expense> expenseList(User user) {
        return userDao.expenseList(user);
    }

    public Expense getExpense(int id) {
        return userDao.getExpense(id);
    }

    public boolean updateExpense(Expense expense) {
        return userDao.updateExpense(expense);
    }
}
