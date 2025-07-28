package org.pronet.app.servlets;

import org.pronet.app.models.Teacher;
import org.pronet.app.services.TeacherService;
import org.pronet.app.utils.ParameterUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "teacherServlet", value = "/teacher")
public class TeacherServlet extends HttpServlet {
    private final TeacherService teacherService = new TeacherService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = ParameterUtil.getStringValue(request.getParameter("firstName"));
        String lastName = ParameterUtil.getStringValue(request.getParameter("lastName"));
        String email = ParameterUtil.getStringValue(request.getParameter("email"));
        final List<Teacher> teachers = teacherService.getAll(firstName, lastName, email);
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("views/teacher/teachers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        final long id = ParameterUtil.getLongValue(request.getParameter("id"));
        final String actionType = ParameterUtil.getStringValue(request.getParameter("actionType"));
        String firstName = ParameterUtil.getStringValue(request.getParameter("firstName"));
        String lastName = ParameterUtil.getStringValue(request.getParameter("lastName"));
        String email = ParameterUtil.getStringValue(request.getParameter("email"));

        if (actionType.equalsIgnoreCase("create")) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(firstName).setLastName(lastName).setEmail(email);
            teacherService.create(teacher);
        } else if (actionType.equalsIgnoreCase("edit")) {
            Teacher teacher = new Teacher();
            teacher.setFirstName(firstName).setLastName(lastName).setEmail(email);
            teacherService.update(id, teacher);
        } else if (actionType.equalsIgnoreCase("remove")) {
            teacherService.deleteById(id);
        }
        response.sendRedirect("teacher");
    }
}
