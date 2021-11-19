package com.jwd.dao.repository.impl;

import com.jwd.dao.configuration.DataBaseConfig;
import com.jwd.dao.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl {

  private final DataBaseConfig dataBaseConfig;

  public UserDaoImpl() {
    dataBaseConfig = new DataBaseConfig();
  }

  public List<User> getUsers() throws SQLException {
    String query = "SELECT * FROM users;";
    Connection connection = dataBaseConfig.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement(query);
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.print(resultSet.getLong(1) + " ");
      System.out.print(resultSet.getString(2)+ " ");
      System.out.print(resultSet.getString(3)+ " ");
      System.out.print(resultSet.getString(4)+ " ");
      System.out.print(resultSet.getString(5)+ " ");
      System.out.print(resultSet.getLong(6)+ " \n");
    }
    return null;
  }

  public static void main(String[] args) throws SQLException {
    UserDaoImpl dao = new UserDaoImpl();
    dao.getUsers();
  }

}
