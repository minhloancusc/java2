package mypack;

import java.util.List;

/**
 *
 * @author minhloan
 */
public class NewMain {
    
    public static void main(String[] args) {
        Region region = new Region();
        
        //View        
//        List<Region> regionList = region.showAllRegion();
//        for(Region r:regionList){
//            System.out.println(r.getRegionID()+"\t"+r.getRegionDescription());
//        }
        
        //Insert 1
        //region.insertRegion1(8, "Dong thap");
//        Region r2 = new Region(9, "Bac Lieu");
//        region.insertRegion2(r2);
        //Update
//        region.updateRegion(8, "An Giang");
        //Delete
        region.deleteRegion(8);
        //View        
        List<Region> regionList = region.showAllRegion();
        for(Region r:regionList){
            System.out.println(r.getRegionID()+"\t"+r.getRegionDescription());
        }
    }

}
