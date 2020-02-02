import java.util.Comparator;
/**
 * PostcodeComparator compares the postcodes of two cities, implementing the 
 * Comparator interface to evaluate the difference between two to determine 
 * which locations are farther away from each other.
 *
 * @author Audrea Huang
 * @version 02/01/2019
 */
public class PostcodeComparator implements Comparator<Row>
{
    /**
     * Compares two rows to determine which location has a greater zip code.
     * 
     * @param  row1, row2  two rows from the data to compare eviction rates of
     * @return int  1 if the city corresponding to the first row has a bigger zip code 
     *                than the second row, -1 if lower, and 0 if equal
     */
    
    public int compare(Row row1, Row row2) {
        double zipDiff = row1.getPostcode() - row2.getPostcode();
        return zipDiff > 0.0 ? 1 : 
               zipDiff == 0.0 ? 0 : -1;
    }
}