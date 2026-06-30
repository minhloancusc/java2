package mypack;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

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
    
    
    public List<Region> showAllRegion(){
        List<Region> regionList = new ArrayList();
        Connection conn = MyConnection.getConnection();
        String sql = "select RegionID,RegionDescription from Region";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Region r = new Region(rs.getInt("RegionID"),rs.getString("RegionDescription"));
                regionList.add(r);
            }
            return regionList;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return regionList;
    }

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
