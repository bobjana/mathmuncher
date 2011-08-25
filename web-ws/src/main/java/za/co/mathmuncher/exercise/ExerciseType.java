package za.co.mathmuncher.exercise;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:simpleType xmlns:ns="http://mathmuncher.co.za/ws/schemas/ex" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="exerciseType">
 *   &lt;xs:restriction base="xs:string">
 *     &lt;xs:enumeration value="MULTIPLICATION"/>
 *     &lt;xs:enumeration value="DIVISION"/>
 *     &lt;xs:enumeration value="ADDITION"/>
 *     &lt;xs:enumeration value="MINUS"/>
 *   &lt;/xs:restriction>
 * &lt;/xs:simpleType>
 * </pre>
 */
public enum ExerciseType {
    MULTIPLICATION, DIVISION, ADDITION, MINUS
}
