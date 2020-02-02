/**
 * FilterOpenProjects filters the data to only include projects that are 
 * still currently open, ignoring projects that have already been completed
 * along with confidential projects, since users cannot live in them at the 
 * moment.
 *
 * @author Audrea Huang
 * @version 2/1/2020
 */
public class FilterOpenProjects implements FilterPredicate<Row>
{
    /**
     * Determines if the data pertains to a current project.
     * 
     * @return boolean  True if data is related to an open project.
     * @param  element  a single row from the data table
     */
    public boolean apply(Row element) {
        String project = element.getProject();
        return element.getDataValue("Project Completion Date") != null &&
               !project.equals("CONFIDENTIAL");
    }
}