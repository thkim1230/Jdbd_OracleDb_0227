package com.kh.jdbc.util;
import java.sql.*;
// DB 와 연결 클래스
public class Common {
    final static String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    final static String ORACLE_ID = "SCOTT";
    final static String ORACLE_PWD = "TIGER";
    final static String ORACLE_DRV = "oracle.jdbc.driver.OracleDriver";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(ORACLE_DRV); // 오라클 디바이스 드라이버 로딩
            conn = DriverManager.getConnection(ORACLE_URL,ORACLE_ID,ORACLE_PWD); // 연결 얻기

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close (Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Connection 해제 성공");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void close (Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
                System.out.println("Statement 해제 성공");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void close(ResultSet rSet) {
        try {
            if (rSet != null && !rSet.isClosed()) {
                rSet.close();
                System.out.println("ResultSet 해제 성공");
            }

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
