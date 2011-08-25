package za.co.mathmuncher.exercise;

    /**
     * Schema fragment(s) for this class:
     * <pre>
     * &lt;xs:element xmlns:ns="http://mathmuncher.co.za/ws/schemas/ex" xmlns:xs="http://www.w3.org/2001/XMLSchema" name="anthropods" minOccurs="0" maxOccurs="unbounded">
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

   public class Anthropod {

        private Integer body;
        private String legs;
        private String name;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
}