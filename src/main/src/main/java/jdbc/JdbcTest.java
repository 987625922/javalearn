package jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;


@Slf4j
public class JdbcTest {



//    public static void main(String args[]) {
//        String jdbcDrive = "com.mysql.cj.jdbc.Driver";
//        String connection = "jdbc:mysql://127.0.0.1:3306/springbootlearn?characterEncoding=UTF-8&serverTimezone=GMT%2B8";
//        Connection con = null;
//        ResultSet resultSet = null;
//        Statement insertStmt = null;
//        PreparedStatement insertPs = null;
//        PreparedStatement selectStmt = null;
//        try {
//            //驱动类com.mysql.jdbc.Driver
//            //就在 mysql-connector-java-5.0.8-bin.jar中
//            //如果忘记了第一个步骤的导包，就会抛出ClassNotFoundException
//            Class.forName(jdbcDrive);
//            //连接对象
//            con = DriverManager.getConnection(connection, "root", "root");
//
//            /**
//             * 执行数据库插入(增删改都是使用这种方式只是SQL语句不一样)
//             */
//            insertStmt = con.createStatement();
//            String insertSql = "insert into user(name) values(" + "'用户名'" + ")";
//            insertStmt.execute(insertSql);
//
//            // 关闭自动提交
//            con.setAutoCommit(false);
//            String sql2 = "insert into user(name) values(?)";
//            insertPs = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
//            insertPs.setString(1, "用户名");
//            insertPs.execute();
//            // 手动提交事务
//            con.commit();
//            // 在执行完插入语句后，MySQL会为新插入的数据分配一个自增长id
//            // JDBC通过getGeneratedKeys获取该id
//            ResultSet rs = insertPs.getGeneratedKeys();
//            if (rs.next()) {
//                int id = rs.getInt(1);
//                log.debug("插入的主键：" + id);
//            }
//
//            /**
//             * 执行数据库查询
//             */
//            String sql = "select * from user";
//            selectStmt = con.prepareStatement(sql);
//            resultSet = selectStmt.executeQuery();
//            while (resultSet.next()) {
//                log.debug("jdbc查询结果：" + "id:" + resultSet.getString("id")
//                        + "  name:" + resultSet.getString("name"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("jdbc连接失败");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("jdbc找不到驱动");
//        } finally {
//            // 不一定要在这里关闭ReultSet，因为Statement关闭的时候，会自动关闭ResultSet
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 先关闭Statement
//            if (insertStmt != null) {
//                try {
//                    insertStmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (insertPs != null) {
//                try {
//                    insertPs.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 先关闭Statement
//            if (selectStmt != null) {
//                try {
//                    selectStmt.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            // 后关闭Connection
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//    }
}
