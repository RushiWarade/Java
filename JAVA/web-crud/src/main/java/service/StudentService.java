package service;

import dao.StudentDao;
import model.StudentModel;

public class StudentService {
    public StudentDao studentDao = new StudentDao();

    public static void add(StudentModel studentModel) {
        StudentDao.add(studentModel);

    }
}
