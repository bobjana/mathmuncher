
package za.co.mathmuncher.exercise;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://mathmuncher.co.za/ws/schemas/ex" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="type">
 *   &lt;xs:complexType>
 *     &lt;xs:attribute type="ns:exerciseType" name="type"/>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class ExerciseRequest
{
    private ExerciseType type;

    public ExerciseRequest(ExerciseType type) {
        this.type = type;
    }

    public ExerciseRequest(){}

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }
}
