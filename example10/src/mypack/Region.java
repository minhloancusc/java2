package mypack;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author minhloan
 */
public class Region {

    private int regionID;
    private String regionDescription;

    public Region() {
        this.regionID = 0;
        this.regionDescription = null;
    }

    public Region(int regionID, String regionDescription) {
        this.regionID = regionID;
        this.regionDescription = regionDescription;
    }

    //Way 1
    public ResultSet showAllRegion() {
        ResultSet rs = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //conn.close();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    //Way 2
    public List<Region> showAllRegion2() {
        List<Region> listRegion = new ArrayList<>();
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Region r = new Region(rs.getInt("RegionID"),rs.getString("RegionDescription"));
                listRegion.add(r);
            }
            conn.close();
            return listRegion;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return listRegion;
    }

    public void insertRegion(int regionID, String regionDescription) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "insert into Region (RegionID,RegionDescription) values (" + regionID + ",'" + regionDescription + "')";
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateRegion(int regionID, String regionDescription) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "update Region set RegionDescription = '" + regionDescription + "' where RegionID =" + regionID;
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteRegion(int regionID) {
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "delete Region where RegionID =" + regionID;
            Statement stmt = conn.createStatement();
            stmt.executeQuery(sql);
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public ResultSet findRegionbyDesc(String keyword) {
        ResultSet rs = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region where RegionDescription like '%" + keyword + "%'";
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            conn.close();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

    public ResultSet findRegionbyID(int regionID) {
        ResultSet rs = null;
        try {
            Connection conn = MyConnection.getConnection();
            String sql = "select RegionID,RegionDescription from Region where RegionID =" + regionID;
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            conn.close();
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rs;
    }

//    public static void main(String[] args) {
//        try {
//            Connection conn = MyConnection.getConnection();
//            String sql = "select RegionID,RegionDescription from Region";
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery(sql);
//            while(rs.next()){
//                System.out.println(rs.getInt("RegionID")+"\t"+rs.getString("RegionDescription"));
//            }
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//        
//    }
    public int getRegionID() {
        return regionID;
    }

    public void setRegionID(int regionID) {
        this.regionID = regionID;
    }

    public String getRegionDescription() {
        return regionDescription;
    }

    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }
}
