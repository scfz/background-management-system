package com.hzlx.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T> {
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet resultSet;
    /**
     * 通用的 增删改方法
     * @param sql 需要执行的sql 其中包含(?占位符)
     * @param objs ?对应的参数 可变参数列表
     */
    public int executeUpdate(String sql, Object... objs){
        int rows = 0;
        try {
            connection = ConnectionPool.getConnection();
            // 获取sql预执行器
            ps = connection.prepareStatement(sql);
            // 替换?占位符
            for (int i = 0; i <objs.length ; i++) {
                // 循环替换?
                ps.setObject(i+1,objs[i]);
            }
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQL执行异常");
            e.printStackTrace();
        }finally {
            ConnectionPool.closeAll(connection,ps,null);
        }
        return rows;
    }
    /**
     * 查询数据封装成一个对象
     *
     * @param sql  执行的sql语句
     * @param objs 参数列表
     */
    public T selectOne(String sql, Class clazz, Object... objs){
        Object obj = null;
        try {
            // 获取数据库连接
            connection = ConnectionPool.getConnection();
            // 获取sql预执行器
            ps = connection.prepareStatement(sql);
            // 替换?占位符
            for (int i = 0; i < objs.length; i++) {
                // 循环替换?
                ps.setObject(i+1,objs[i]);
            }
            // 执行sql,获取结果集
            resultSet = ps.executeQuery();

            if (resultSet.next()){
                // 从结果集中解析数据并封装为一个对象
                obj = clazz.newInstance();
                // 通过反射获取对象的所以属性
                Field[] fields =clazz.getDeclaredFields();
                // 通过属性名字找到对应的set方法,执行set方法完成赋值操作
                for (int i = 0; i < fields.length; i++) {
                    // 获取字段名
                    String fieldName = fields[i].getName();
                    // 截取字段首字母转大写
                    String oldChar =  fieldName.substring(0,1);
                    // 通过字段名找到对应的set方法名
                    String methodName = "set"+ oldChar.toUpperCase()+fieldName.substring(1);
                    Method[] methods = clazz.getMethods();
                    // 通过反射找到对应的方法,并执行它,完成赋值操作
                    Method method = clazz.getMethod(methodName,fields[i].getType());
                    // 执行对应的set方法,给对象赋值
                    method.invoke(obj,resultSet.getObject(i+1));
                }

            }
        } catch (SQLException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("对象实例化失败");
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("没有找到对应的set方法");
            e.printStackTrace();
        }finally {
            ConnectionPool.closeAll(connection,ps,resultSet);
        }
        return (T) obj;
    }
    /**
     * 查看多个结果-->对象
     * @return 集合
     */
    public List<T> selectListForObject(String sql, Class clazz, Object... objects){
        // 存放结果的集合
        List<T> list = null;
        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(sql);
            // 替换?占位符
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            // 执行SQL获取结果集
            resultSet = ps.executeQuery();
            list = new ArrayList<>();
            // 遍历结果集,封装对象放到list中
            while(resultSet.next()){
                // 通过反射创建对象
                Object obj = clazz.newInstance();
                Field[] fields = clazz.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    String name = fields[i].getName();
                    String firstChar = name.substring(0,1).toUpperCase();
                    String methodName = "set"+firstChar+name.substring(1);
                    Method method = clazz.getMethod(methodName,fields[i].getType());
                    method.invoke(obj,resultSet.getObject(i+1));
                }
                list.add((T) obj);
            }
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
           e.printStackTrace();
        } catch (InstantiationException | IllegalAccessException e) {
           e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("没有对应的set方法");
           e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("赋值失败");
           e.printStackTrace();
        }finally {
            ConnectionPool.closeAll(connection,ps,resultSet);
        }
        return list;
    }
    /**
     * 查询单条数据,把结果封装到map集合中
     * @reture 结果集
     */
    public Map<String,Object> selectOneForMap(String sql,Object... objects){
        Map<String,Object> map =null;

        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            resultSet  = ps.executeQuery();
            map = new HashMap<>();
            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();
            if (resultSet.next()){
                for (int i = 1; i <= columnCount; i++) {
                    String columName = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columName);
                    map.put(columName,value);
                }
            }
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }finally {
            ConnectionPool.closeAll(connection,ps,resultSet);
        }
        return map;
    }
    /**
     * 查询多条数据,把结果封装到List集合中
     * @reture 结果集
     */
    public List<Map<String,Object>> selectListForMap(String sql,Object... objects){
        List<Map<String,Object>> list = null;

        try {
            connection = ConnectionPool.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            resultSet = ps.executeQuery();
             list = new ArrayList<>();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while(resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i+1);
                    Object value = resultSet.getObject(columnName);
                    map.put(columnName,value);
                }
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println("数据库连接异常");
            e.printStackTrace();
        }finally {
            ConnectionPool.closeAll(connection,ps,resultSet);
        }
        return list;
    }

}