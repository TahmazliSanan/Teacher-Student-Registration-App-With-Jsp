package org.pronet.app.services;

import org.pronet.app.models.Subject;
import org.pronet.app.repositories.BaseRepository;
import org.pronet.app.utils.DbConnectionUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SubjectService implements BaseRepository<Subject> {
    @Override
    public void create(Subject subject) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("insert into subjects (name, teacher_id) values (?, ?)")) {
            statement.setString(1, subject.getName());
            statement.setLong(2, subject.getTeacherId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Subject getById(Long id) {
        try {
            PreparedStatement statement = DbConnectionUtil.getConnection()
                    .prepareStatement("select * from subjects where id = ?");
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return new Subject(id, resultSet.getString("name"), resultSet.getLong("teacher_id"));
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Subject> getAll() {
        ResultSet resultSet;
        try (Statement statement = DbConnectionUtil.getConnection().createStatement()) {
            resultSet = statement.executeQuery("select * from subjects");
            List<Subject> subjects = new ArrayList<>();
            while (resultSet.next())
                subjects.add(new Subject(resultSet.getLong("id"), resultSet.getString("name"),
                        resultSet.getLong("teacher_id")));
            return subjects;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Subject subject) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("update subjects set name = ?, teacher_id = ? where id = ?")) {
            statement.setString(1, subject.getName());
            statement.setLong(2, subject.getTeacherId());
            statement.setLong(3, subject.getId());
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (PreparedStatement statement = DbConnectionUtil.getConnection()
                .prepareStatement("delete from subjects where id = ?")) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
