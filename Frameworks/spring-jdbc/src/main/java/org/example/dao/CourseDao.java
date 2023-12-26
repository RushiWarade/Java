package org.example.dao;

import org.example.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addCourse(Course course) {
        String sql = "insert into course(course_id,name,email,mobile) values (?,?,?,?)";
        jdbcTemplate.update(sql, (ps) -> {
            ps.setInt(1, course.getId());
            ps.setString(2, course.getName());
            ps.setString(3, course.getEmail());
            ps.setString(4, course.getMobile());
        });
    }

    public void updateCourse(Course course) {
        String sql = "update course set name=?,mobile=? where course_id=?";
        jdbcTemplate.update(sql, course.getName(), course.getMobile(), course.getId());//also we can write lambda here
    }

    public void deleteCourse(Course course) {
        String sql = "delete  from  course where course_id=?";
        jdbcTemplate.update(sql, course.getId());//also we can write lambda here
    }

    public Course getCourseById(int id) {
        String sql = "select * from  course where course_id=?";
        RowMapper<Course> rowMapper = (rs, rowNum) ->
                Course.builder()
                        .id(rs.getInt("course_id"))
                        .email(rs.getString(2))
                        .mobile(rs.getString(3))
                        .name(rs.getString(4))
                        .build();

        Course course = jdbcTemplate.queryForObject(sql, rowMapper, id);//also we can write lambda here
        return course;
    }

    public List<Course> getAllCourse() {
        String sql = "select * from course";

        List<Course> courseList = jdbcTemplate.query(sql, (rs, rowNum) ->
                Course.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(4))
                        .email(rs.getString(2))
                        .mobile(rs.getString(3))
                        .build());


        return courseList;
    }

}
