/**
 * filename: Row.java
 * description: Initializes Row class
 * date: 02/01/2020
 * @author Audrea Huang
 */

import java.util.HashMap;

public class Row {
    
    private final String project;
    private final double postcode;
    private final double latitude;
    private final double longitude;
    private final HashMap<String, String> data;

    /**
     * Constructor for Row class. 
     * Each Row represents data on the project level.
     */
    public Row(
        String project,
        String start,
        String projectEnd,
        String buildingID,
        String addrNumber,
        String street,
        String borough,
        String buildingEnd,
        String constructType,
    ) {
        this.project = project;
        
        this.data = new HashMap<String, String>();
        this.data.put("Project Name", name);
        this.data.put("Project Start Date", start);
        this.data.put("Project Completion Date", eighteen);
        this.data.put("Building ID", buildingID);
        this.data.put("Number", addrNumber);
        this.data.put("Street", twentyOne);
        this.data.put("Borough", borough);
        this.data.put("Building Completion Date", buildingEnd);
        this.data.put("Reporting Construction Type", constructType);
    }

    /**
     * Getter method for project name variable.
     * @return project name data for this Row instance.
     */
    public final String getProject() {
        return this.project;
    }

    /**
     * Getter method for project postcode.
     * @return postcode for project.
     */
    public final double getPostcode() {
        return this.postcode;
    }

    /**
     * Getter method for project location latitude.
     * @return latitude for project.
     */
    public final double getLatitude() {
        return this.latitude;
    }

    /**
     * Getter method for project location longitude.
     * @return longitude for project.
     */
    public final double getLongitude() {
        return this.longitude;
    }
    
    /**
     * Getter method for all numerical values associated with this row.
     * @return numerical value associated with this row.
     */
    public final double getDataValue(String variableName) {
        if( this.data.containsKey(variableName) ) {
            return this.data.get(variableName);
        }
        throw new IllegalArgumentException(
            "Row objects do not contain the variable '" + variableName + "'!");
    }

    /**
     * Returns a String representing all the data in this Row instance.
     @return a String representation of this Row.
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("word=" + this.definition);
        sb.append("}");
        return sb.toString();
    }
}