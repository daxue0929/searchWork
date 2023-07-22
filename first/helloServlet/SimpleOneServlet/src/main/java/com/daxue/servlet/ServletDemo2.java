package com.daxue.servlet;

import com.daxue.pojo.User;
import com.daxue.util.DBUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author daxue0929
 * @date 2023/7/23
 *
 * http://localhost:9090/SimpleOneServlet/demo2
 */

@WebServlet(urlPatterns = {"/demo2", "/demo2-1"})
public class ServletDemo2 extends HttpServlet {

    public Connection connection = null;

    @Override
    public void init() throws ServletException {
        connection = DBUtil.getCollection();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet start.........");
        resp.setHeader("Content-Type", "application/json;charset=utf-8");
        try {
        String sql = "select * from `user` where id = 1";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                ObjectMapper mapper = new ObjectMapper();
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                String result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
                resp.getWriter().write(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    public void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
