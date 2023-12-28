package com.example.demo1.database;


import com.example.demo1.models.Courses;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.*;
public class DataBase {
    public Connection connect_to_db() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + "examen_db", "postgres", "123");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public int check_login(String login) {
        try {
            String query = String.format("select * from users where login = '%s'", login);
            Statement statement = connect_to_db().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.last();
            if (resultSet.getRow() >= 1) {
                return 0;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 404;
        }
        return 201;
    }

    public int signIn(String login, String password) {
        try {
            String query = String.format("select * from users where login = '%s' and password = '%s'", login, password);
            Statement statement = connect_to_db().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 404;
        }
        return 201;
    }

    public void updateDataUser(String login, String password, String role, String id) {
        try {
            String query = String.format("update users set login='%s', password='%s', role='%s', status='Офлайн' where id='%s'", login, password, role, id);
            Statement statement = connect_to_db().createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
            //12311
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ObservableList<Courses> getAllCourses() {
        ObservableList<Courses> users = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = connect_to_db().createStatement().executeQuery("select * from courses");
            while (resultSet.next()) {
                users.add(new Courses(
                        resultSet.getString("name"),
                        resultSet.getString("price"),
                        resultSet.getString("period_education"),
                        resultSet.getString("curator")
                ));
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return users;
        }
    }

    public void updateDataUser(String login, String password, String role, String status, String id) {
        try {
            String query = String.format("update users set login='%s', password='%s', role='%s', status='%s' where id='%s'", login, password, role, status, id);
            Statement statement = connect_to_db().createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void deleteDataUser(String id) {
        try {
            String query = String.format("delete from users where id='%s'",id);
            connect_to_db().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createUser(String firstName, String secondName, String lastName, String email, String login, String password) {
        try {
            String query = String.format("insert into users (firstName, secondName, lastName, email, login, password) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",firstName, secondName, lastName, email, login, password);
            connect_to_db().createStatement().executeUpdate(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}