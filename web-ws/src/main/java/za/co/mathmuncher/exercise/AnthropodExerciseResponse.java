
package za.co.mathmuncher.exercise;

import java.util.ArrayList;
import java.util.List;

/** 
 * Schema fragment(s) for this class:
 * <pre>
 * &lt;xs:element xmlns:ns="http://mathmuncher.co.za/ws/schemas/ox" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="anthropodExerciseResponse">
 *   &lt;xs:complexType>
 *     &lt;xs:sequence>
 *       &lt;xs:element name="anthropods" minOccurs="0" maxOccurs="unbounded">
 *         &lt;!-- Reference to inner class Anthropod -->
 *       &lt;/xs:element>
 *     &lt;/xs:sequence>
 *     &lt;xs:attribute type="ns:exerciseType" name="type"/>
 *   &lt;/xs:complexType>
 * &lt;/xs:element>
 * </pre>
 */
public class AnthropodExerciseResponse {

    private List<Anthropod> anthropods = new ArrayList<Anthropod>();
    private ExerciseType type;

    public List<Anthropod> getAnthropods() {
        return anthropods;
    }

    public void setAnthropods(List<Anthropod> list) {
        anthropods = list;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    /** 
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:element xmlns:ns="http://mathmuncher.co.za/ws/schemas/ox" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="anthropods" minOccurs="0" maxOccurs="unbounded">
     *   &lt;xs:complexType>
     *     &lt;xs:simpleContent>
     *       &lt;xs:extension base="xs:string">
     *         &lt;xs:attribute type="xs:int" use="required" name="body"/>
     *         &lt;xs:attribute type="xs:string" use="required" name="legs"/>
     *       &lt;/xs:extension>
     *     &lt;/xs:simpleContent>
     *   &lt;/xs:complexType>
     * &lt;/xs:element>
     * </pre>
     */
    public static class Anthropod
    {
        private Integer body;
        private String legs;

        /** 
         * Get the 'body' attribute value.
         * 
         * @return value
         */
        public Integer getBody() {
            return body;
        }

        /** 
         * Set the 'body' attribute value.
         * 
         * @param body
         */
        public void setBody(Integer body) {
            this.body = body;
        }

        /** 
         * Get the 'legs' attribute value.
         * 
         * @return value
         */
        public String getLegs() {
            return legs;
        }

        /** 
         * Set the 'legs' attribute value.
         * 
         * @param legs
         */
        public void setLegs(String legs) {
            this.legs = legs;
        }
    }
}
