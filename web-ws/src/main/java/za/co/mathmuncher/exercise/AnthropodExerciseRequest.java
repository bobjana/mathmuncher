
package za.co.mathmuncher.exercise;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://mathmuncher.co.za/ws/schemas/ox" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="type">
 *   &lt;xs:complexType>
 *     &lt;xs:attribute type="ns:exerciseType" name="type"/>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class AnthropodExerciseRequest
{
    private ExerciseType type;

    public AnthropodExerciseRequest(ExerciseType type) {
        this.type = type;
    }

    public AnthropodExerciseRequest(){}

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }
}
