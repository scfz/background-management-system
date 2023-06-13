package com.hzlx.utils;

import java.sql.*;
import java.util.LinkedList;

// 自定义链接池
public class ConnectionPool {
    // 最小连接数
    private static int MIN_POOL_NUM;
    // 最大连接数
    private static int MAX_POOL_NUM;

    private static String DRIVER;

    private static String URL;

    private static String USERNAME;

    private static String PASSWORD;
    private static LinkedList<Connection> connectionPool = new LinkedList<>();

    static {
        init();
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("加载数据库驱动异常");
            e.printStackTrace();
        }
        // 给连接池填充连接
        initConnection();
    }
    /**
     * 初始化方法,给属性赋值
     * */
    private static void init(){
        // 先把jdbc配置文件加载到程序里
        PropertiesUtil.load("jdbc");
        // 根据配置文件类的key给连接池中的属性赋值
        DRIVER = PropertiesUtil.getValue("jdbc.driver");
        URL = PropertiesUtil.getValue("jdbc.url");
        USERNAME = PropertiesUtil.getValue("jdbc.userName");
        PASSWORD = PropertiesUtil.getValue("jdbc.password");
        // 连接池相关的属性赋值
        MIN_POOL_NUM =Integer.parseInt(PropertiesUtil.getValue("jdbc.minPoolNum"));
        MAX_POOL_NUM =Integer.parseInt(PropertiesUtil.getValue("jdbc.maxPoolNum"));
    }
    /**
     * 连接池初始化
     */
    private static void initConnection(){
        for (int rows = 0; rows < MIN_POOL_NUM; rows++) {
            try {
                // 每创建一个新的连接都往集合尾部追加
              connectionPool.addLast(DriverManager.getConnection(URL,USERNAME,PASSWORD));
            } catch (SQLException e) {
                System.out.println("初始化获取连接异常");
                e.printStackTrace();
            }
        }
    }
    /**
     * 获取连接对象
     * */
    public static Connection getConnection(){
        //判断兰坚持是否有可用连接,如果有取出最顶端的,如果没有创建一个并返回
        if (connectionPool.size() > 0){
            return connectionPool.removeFirst();
        }
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("获取连接异常");
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 归还连接的方法
     * connection 换回来的连接对象
     * true 归还成功,false 归还失败
     * */
    private static boolean returnConnection(Connection connection){
        // 当前连接池集合的size是否大于或等于配置好的最大连接数,满了连接丢弃
        if (connectionPool.size() >= MAX_POOL_NUM){
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                System.out.println("关闭连接异常");
                e.printStackTrace();
            }
        }else {
            connectionPool.addLast(connection);
            return true;
        }
        return false;
    }
    /**
     * 关闭连接,释放资源的方法
     * */
    public static boolean closeAll(Connection connection, PreparedStatement ps, ResultSet resultSet){
        if (resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("关闭结果集异常");
                e.printStackTrace();
            }
        }
        if (ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("关闭Ps失败");
                e.printStackTrace();
            }
        }
        return returnConnection(connection);
    }
}
