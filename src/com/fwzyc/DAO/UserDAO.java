package com.fwzyc.DAO;

import com.fwzyc.DB.DBUtil;
import com.fwzyc.VO.UserVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO {
    public boolean Login_verify(String username, String password) {
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from user where username='" + username + "' and password='" + password+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return false;
    }

    public String getAdddm(String username, String password) {
        String str = null;
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from user where username='" + username + "' and password='" + password+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) {
                UserVo userVo = new UserVo();
                str = rs.getString("adddm");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return str;
    }

    /**
     * 查询所有用户信息
     * @return ArrayList集合
     */
    public ArrayList<UserVo> get_ListInfo() {
        ArrayList<UserVo> list = new ArrayList<>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from user where isdel = 1";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                UserVo userVo = new UserVo();
                userVo.setId(rs.getInt("id"));
                userVo.setUsername(rs.getString("username"));
                userVo.setPassword(rs.getString("password"));
                String str = rs.getString("sex");
                if("1".equals(str)){
                    userVo.setSex("男");
                }else{
                    userVo.setSex("女");
                }
                userVo.setAddress(rs.getString("address"));
                String str1 = rs.getString("adddm");
                if ("0".equals(str1)){
                    userVo.setAdddm("管理员用户");
                } else if ("1".equals(str1)){
                    userVo.setAdddm("北京用户");
                }else if ("2".equals(str1)){
                    userVo.setAdddm("天津用户");
                }else if ("3".equals(str1)){
                    userVo.setAdddm("河北用户");
                }else {
                    userVo.setAdddm("其他用户");
                }
                list.add(userVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return list;
    }

    /**
     * 实现用户id信息的假删除
     * @param id
     */
    public void deleteUser(String id) {
        Connection conn = DBUtil.getConnectDb();
        String sql = "update user set isdel = 0 where id = '"+id+"'";
        PreparedStatement stm = null;
        try {
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 根据用户id查询用户详细信息
     * @param id
     * @return ArrayList集合
     */
    public ArrayList<UserVo> selectUserById(String id) {
        ArrayList<UserVo> list = new ArrayList<>();
        Connection conn = DBUtil.getConnectDb();
        String sql = "select * from user where isdel = 1 and id = '"+id+"'";
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                UserVo userVo = new UserVo();
                userVo.setId(rs.getInt("id"));
                userVo.setUsername(rs.getString("username"));
                userVo.setPassword(rs.getString("password"));
                String str = rs.getString("sex");
                if("1".equals(str)){
                    userVo.setSex("男");
                }else{
                    userVo.setSex("女");
                }
                userVo.setAddress(rs.getString("address"));
                String str1 = rs.getString("adddm");
                if ("0".equals(str1)){
                    userVo.setAdddm("管理员用户");
                } else if ("1".equals(str1)){
                    userVo.setAdddm("北京用户");
                }else if ("2".equals(str1)){
                    userVo.setAdddm("天津用户");
                }else if ("3".equals(str1)){
                    userVo.setAdddm("河北用户");
                }else {
                    userVo.setAdddm("其他用户");
                }
                list.add(userVo);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            DBUtil.CloseDB(rs, stm, conn);
        }
        return list;
    }
}
