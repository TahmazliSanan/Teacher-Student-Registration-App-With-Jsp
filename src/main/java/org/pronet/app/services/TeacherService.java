package org.pronet.app.services;

import org.pronet.app.models.Teacher;
import org.pronet.app.repositories.BaseRepository;
import org.pronet.app.utils.DbConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherService implements BaseRepository<Teacher> {
    @Override
    public void create(Teacher teacher) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("insert into teachers (first_name, last_name, email) values (?, ?, ?)")) {
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getEmail());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Teacher getById(Long id) {
        try {
            PreparedStatement statement = DbConnectionUtil.getConnection()
                    .prepareStatement("select * from teachers where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return new Teacher(id, resultSet.getString("first_name"), resultSet.getString("last_name"),
                        resultSet.getString("email"));
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Teacher> getAll() {
        ResultSet resultSet;
        try (Statement statement = DbConnectionUtil.getConnection().createStatement()) {
            resultSet = statement.executeQuery("select * from teachers");
            List<Teacher> teachers = new ArrayList<>();
            while (resultSet.next())
                teachers.add(new Teacher(resultSet.getLong("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("email")));
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Teacher> getAll(String firstName, String lastName, String email) {
        String query = "select * from teachers where true";
        int index = 0;

        if (firstName != null && !firstName.trim().isEmpty()) {
            query += " and first_name = ?";
            index++;
        } if (lastName != null && !lastName.trim().isEmpty()) {
            query += " and last_name = ?";
            index++;
        } if (email != null && !email.trim().isEmpty()) {
            query += " and email = ?";
            index++;
        }

        ResultSet resultSet;
        try (PreparedStatement statement = DbConnectionUtil.getConnection().prepareStatement(query)) {
            if (email != null && !email.trim().isEmpty())
                statement.setString(index--, email);
            if (lastName != null && !lastName.trim().isEmpty())
                statement.setString(index--, lastName);
            if (firstName != null && !firstName.trim().isEmpty())
                statement.setString(index, firstName);

            resultSet = statement.executeQuery();
            List<Teacher> teachers = new ArrayList<>();
            while (resultSet.next())
                teachers.add(new Teacher(resultSet.getLong("id"), resultSet.getString("first_name"),
                        resultSet.getString("last_name"), resultSet.getString("email")));
            return teachers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, Teacher teacher) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("update teachers set first_name = ?, last_name = ?, email = ? where id = ?")) {
            statement.setString(1, teacher.getFirstName());
            statement.setString(2, teacher.getLastName());
            statement.setString(3, teacher.getEmail());
            statement.setLong(4, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("delete from teachers where id = ?")) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
