package mypack;

import java.util.List;

/**
 *
 * @author minhloan
 */
public class NewMain {
    
    public static void main(String[] args) {
        Region region = new Region();
        List<Region> regionList = region.showAllRegion();
        for(Region r:regionList){
            System.out.println(r.getRegionID()+"\t"+r.getRegionDescription());
        }
    }

}
