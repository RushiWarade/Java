package controller;

import model.Expense;
import model.User;
import service.UserService;

import java.util.List;

public class UserController {
    UserService userService = new UserService();

    public boolean addUser(User user) {
        return userService.addUser(user);
    }


    public User login(String email, String password) {
        return userService.login(email, password);
    }


    public boolean addExpense(Expense expense) {
        return userService.addExpense(expense);
    }

    public List<Expense> expenseList(User user) {
        return userService.expenseList(user);
    }


    public Expense getExpense(int id) {
        return userService.getExpense(id);
    }


    public boolean updateExpense(Expense expense) {
        return userService.updateExpense(expense);
    }

}
