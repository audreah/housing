/**
 * Driver class to sort the data based on which projects are available for certain areas.
 *
 * @author Audrea Huang
 * @version 02/01/2020
 */

import java.io.IOException;
import java.util.Comparator;

public class Driver
{
    /** 
     * Main method to read and sort the data.
     * 
     * @param  args  command-line arguments
     */
    
    public static void main(String[] args) {
        //FilterOpenProjects filter = new FilterOpenProjects();
        
        try {
            Reader readSmall = new Reader("Housing_New_York_Units_by_Building.csv",1000);
            Comparator<Row> compareZip = new PostcodeComparator();
            
            System.out.println("testing on smaller dataset (1000 rows)");
            FilterableDataset datasetSmall = readSmall.getDataset();
            System.out.println("first element: " + datasetSmall.get(0));
            System.out.println("dataset size: [expect 1000], actual: " + datasetSmall.size());
            FilterableDataset subsetOpen = datasetSmall.filterBy(new FilterOpenProjects());
            sorting.mergeSort(subsetOpen, compareZip);
            System.out.println("First zip code: " + subsetOpen.get(0));
            
            // // print out the 5 cities with the highest eviction rates in order from
            // // greatest to least
            // System.out.println("\nPrinting out 5 cities with highest eviction rates...");
            // System.out.println("[Expected: Howe, Sandusky, Noble, Lake Worth, Dayton]");
            // for (int i = subset2016Small.size() - 1; i >= subset2016Small.size() - 5; i--) {
            //     Row row  = subset2016Small.get(i);
            //     System.out.print(row);
            //     System.out.println(" eviction rate = " + row.getDataValue("evictionRate"));
            // }
            
            // // print out the first 5 cities with the lowest eviction rates in order from
            // // least to greatest
            // System.out.println("\nPrinting out 5 cities with lowest eviction rates...");
            // System.out.println("[Expected: Archer, Lyon Mountain, Cobden, Lenox, Whitefield]");
            // for (int i = 0; i < 5; i++) {
            //     Row row  = subset2016Small.get(i);
            //     System.out.print(row);
            //     System.out.println(" eviction rate = " + row.getDataValue("evictionRate"));
            // }
            
            // // printing out median eviction rate and corresponding city/cities
            // int sizeSmall = subset2016Small.size();
            // if (subset2016Small.size() % 2 == 0) {
            //     double eRate1 = subset2016Small.get(sizeSmall/2).getDataValue("evictionRate");
            //     double eRate2 = subset2016Small.get((sizeSmall/2) + 1).getDataValue("evictionRate");
            //     double avg = (eRate1 + eRate2) / 2;
            //     String name1 = subset2016Small.get(sizeSmall/2).getName();
            //     String name2 = subset2016Small.get((sizeSmall/2) + 1).getName();
            //     System.out.println("\nThe median eviction rate of 2016 is: [expect: 1.065], " +
            //         "actual: " + avg);
            //     System.out.println("The cities with the two middle-most eviction rates are: " +
            //         "[expect: Ellijay and Belhaven], actual: " + name1 + " and " + name2);
            // } else {
            //     double eRate = subset2016Small.get(sizeSmall/2 + 1).getDataValue("evictionRate");
            //     String name = subset2016Small.get(sizeSmall/2 + 1).getName();
            //     System.out.println("\nThe median eviction rate in 2016 is: " + eRate);
            //     System.out.println("The city with this eviction rates is: " + name);
            // }
            
            
            // // Native American populations and poverty rates
            // FilterableDataset subsetNASmall = datasetSmall.filterBy(new FilterToNAPop());
            // Comparator<Row> comparePovSmall = new PovertyComparator();
            // System.out.println("\nSet of cities with a population percentage of " +
            //     "Native Americans greater than 50%:");
            // System.out.println("subset first element: [expect Thoreau, NM], actual: " + 
            //     subsetNASmall.get(0));
            // System.out.println("subset size: [expect 7], actual:" + subsetNASmall.size());
            // Sorting.mergeSort(subsetNASmall, comparePovSmall);
            
            // // print out the 5 cities with the highest poverty rates for cities in order from
            // // greatest to least
            // System.out.println("\nPrinting out 5 cities with highest poverty rates for " +
            //     "cities with high populations of Native Americans...");
            // System.out.println("[Expected: Nageezi, Ponemah, Thoreau, Dulce, Belfonte]");
            // System.out.println("Actual: ");
            // for (int i = subsetNASmall.size() - 1; i >= subsetNASmall.size() - 5; i--) {
            //     Row row = subsetNASmall.get(i); 
            //     System.out.print(row);
            //     System.out.println(" poverty rate = " + row.getDataValue("povertyRate"));
            // }
            
            
            // // larger data set
            // Reader read = new Reader("eviction.csv",426150);
            
            // System.out.println("\n\nTASK 1 PART 1 (testing on actual dataset)\n");
            // FilterableDataset dataset = read.getDataset();
            // System.out.println("first element: [expect Holland, TX], actual: " + 
            //     dataset.get(0));
            // System.out.println("dataset size: [expect 426150], actual: " + dataset.size());
    
            // System.out.println("\nLooking at eviction data reported for 2016: ");
            // FilterableDataset subset2016 = dataset.filterBy(new FilterTo2016());
            // System.out.println("subset first element: [expect San Carlos, CA], actual: " + 
            //     subset2016.get(0)); 
            // System.out.println("subset size: [expect 25069], actual: " + subset2016.size());
            // Sorting.mergeSort(subset2016, compareEvic);
            
            // // print out the 5 cities with the highest eviction rates in order from
            // // greatest to least
            // System.out.println("\nPrinting out 5 cities with highest eviction rates...");
            // System.out.println("[Expected: Moorefield Station, Robin Glen-Indiantown, " +
            //     "West Monroe, Homestead Base, East Gaffney]");
            // for (int i = subset2016.size() - 1; i >= subset2016.size() - 5; i--) {
            //     Row row  = subset2016.get(i);
            //     System.out.print(row);
            //     System.out.println(" eviction rate = " + row.getDataValue("evictionRate"));
            // }
            
            // // print out the first 5 cities with the lowest eviction rates in order from
            // // least to greatest
            // System.out.println("\nPrinting out 5 cities with lowest eviction rates...");
            // System.out.println("[Expected: Islandia, Owanceo, Goshen, Ashburn, Lupton]");
            // for (int i = 0; i < 5; i++) {
            //     Row row  = subset2016.get(i);
            //     System.out.print(row);
            //     System.out.println(" eviction rate = " + row.getDataValue("evictionRate"));
            // }
            
            // // printing out median eviction rate and corresponding city/cities
            // int size = subset2016.size();
            // if (subset2016.size() % 2 == 0) {
            //     double eRate1 = subset2016.get(size/2).getDataValue("evictionRate");
            //     double eRate2 = subset2016.get((size/2) + 1).getDataValue("evictionRate");
            //     double avg = (eRate1 + eRate2) / 2;
            //     String name1 = subset2016.get(size/2).getName();
            //     String name2 = subset2016.get((size/2) + 1).getName();
            //     System.out.println("\nThe median eviction rate of 2016 is: " + avg);
            //     System.out.println("The cities with the two middle-most eviction rates are: " +
            //         name1 + " and " + name2);
            // } else {
            //     double eRate = subset2016.get(size/2 + 1).getDataValue("evictionRate");
            //     String name = subset2016.get(size/2 + 1).getName();
            //     System.out.println("\nThe median eviction rate in 2016 is: " +
            //         "[expected: 0.55], actual: " + eRate);
            //     System.out.println("The city with this eviction rates is: " +
            //         "[expected: Clear Lake], actual: " + name);
            // }
            
            
            // // Native American populations and poverty rates
            // FilterableDataset subsetNA = dataset.filterBy(new FilterToNAPop());
            // Comparator<Row> comparePov = new PovertyComparator();
            // System.out.println("\nSet of cities with a population percentage " +
            //     "of Native Americans greater than 50%:");
            // System.out.println("subset first element: [expect Thoreau, NM], actual: " + 
            //     subsetNA.get(0));
            // System.out.println("subset size: [expect 5693], actual:" + subsetNA.size());
            // Sorting.mergeSort(subsetNA, comparePov);
            
            // // print out the 5 cities with the highest poverty rates for cities in order from
            // // greatest to least
            // System.out.println("\nPrinting out 5 cities with highest poverty rates for " +
            //     "cities with high populations of Native Americans...");
            // System.out.println("[Expected: Comobabi, Vaiva Vo, Bull Hollow, North Omak, Cowlic]");
            // System.out.println("Actual: ");
            // for (int i = subsetNA.size() - 1; i >= subsetNA.size() - 5; i--) {
            //     Row row = subsetNA.get(i); 
            //     System.out.print(row);
            //     System.out.println(" poverty rate = " + row.getDataValue("povertyRate"));
            // }
        } catch (IOException e) {
            System.out.println("File not found: " + e);
        }
    }
}
