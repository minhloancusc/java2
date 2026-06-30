package mypack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author minhloan
 */
public class MainApp {

    public static void main(String[] args) {
        Region region = new Region();
        //View                
        List<Region> listRegion = region.showAllRegion2();
        for(Region r:listRegion ){
            System.out.println(r.getRegionID()+"\t"+r.getRegionDescription());
        }        
        //Insert
        //region.insertRegion(7, "Tien Giang");
        
        //Edit
        //region.updateRegion(6, "Ca Mau");
        
        //Delete
        region.deleteRegion(7);
        
    }

}
