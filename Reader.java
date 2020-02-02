/**
 * Converts CSV datafile into FilterableDataset.
 */

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Vector;
import fastcsv.*;

public class Reader {

    private final FilterableDataset data;

    /**
     * Constructor for Reader class. Given a path to where eviction data is being
     * stored on your local machine, as well as a number of rows desired, will
     * initialize a FilterableDataset containing the first numRows rows in the dataset.
     *
     * @param filepath - A filepath representing where the csv data file 
     *                   containing eviction data is kept. This can be either a
     *                   relative or absolute filepath - e.g. "eviction.csv" or
     *                   "Users/angie/Desktop/pset4/eviction.csv".
     * @param numRows -  The number of rows desired. Note that if you specify
     *                   more rows of data than exist in the dataset, you will
     *                   get the entire dataset.
     */
    public Reader(String filepath, int numRows) throws IOException {
        this.data = new FilterableDataset();

        File file = new File(filepath);
        CsvReader reader = new CsvReader();
        reader.setContainsHeader(true);

        try (CsvParser parser = reader.parse(file, StandardCharsets.UTF_8)) {
            CsvRow dataRow;
            int currentNumberRows = 0;
            while ( ((dataRow = parser.nextRow()) != null) && 
                    currentNumberRows < numRows ) {
                Row row = new Row(
                    dataRow.getField("Project Name"),
                    dataRow.getField("Project Start Date"),
                    dataRow.getField("Project Completion Date"),
                    dataRow.getField("Building ID"),
                    dataRow.getField("Number"),
                    dataRow.getField("Street"),
                    dataRow.getField("Borough"),
                    getDoubleField(dataRow, "Postcode"),
                    getDoubleField(dataRow, "Latitude"),
                    getDoubleField(dataRow, "Longitude"),
                    dataRow.getField("Building Completion Date"),
                    dataRow.getField("Reporting Construction Type")                    
                );
                data.add(row);
                currentNumberRows++;
            }
        }
    }

    private static double getDoubleField(CsvRow row, String field) {
        return Double.parseDouble(row.getField(field));
    }

    public final FilterableDataset getDataset() {
        return this.data;
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader(
            "/Users/audreahuang/housing/Housing_New_York_Units_by_Building.csv", 680);
        FilterableDataset dataset = reader.getDataset();
        System.out.println("first element: " + dataset.get(0)); // 141 METROPOLITAN AVENUE
        System.out.println("dataset size: " + dataset.size());
    }
}