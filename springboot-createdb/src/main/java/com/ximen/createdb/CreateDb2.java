import org.apache.ibatis.io.Resources;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.IOException;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;

public class CreateDb2 {

  public static void main(String[] args){

    String database = "haier";

    new CreateDb2 ().getConn(database);

  }

  String mysqlDriver = "com.mysql.jdbc.Driver";

  String url = "jdbc:mysql://localhost:3306/mysql";

  String newUrl = "jdbc:mysql://localhost:3306/";

  String username = "root";

  String password = "root";

  Connection conn = null;

  Connection newConn = null;

  public void getConn(String database){

    try {

      Class.forName(mysqlDriver);

    }catch (ClassNotFoundException e){

      e.printStackTrace();

    }

    try{

      String databaseSql = "create database " + database;

 conn = DriverManager.getConnection(url, username, password);

 Statement smt = conn.createStatement();

if (conn != null) {

smt.executeUpdate(databaseSql);

 newConn = DriverManager.getConnection(newUrl + database,

                  username, password);

ScriptRunner runner = new ScriptRunner(newConn);

 runner.setErrorLogWriter(null);

runner.setLogWriter(null);

runner.runScript( Resources.getResourceAsReader("dockerpaas.sql"));

conn.close();

 newConn.close ();

}

}catch (SQLException e1){

e1.printStackTrace();

 } catch (IOException e) {

e.printStackTrace ( );

}

}

}
