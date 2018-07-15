/**
 * Creted by
 * Burak Demirci
 * 141044091
 */
package Part1;

public class Course {

    private int semester;
    private String courseCode,courseTitle;
    private int ectsCredits,gtuCredits;
    private String htl;

    /**
     * The Constructor there is no data need to crete object
     */
    public Course(){
        semester=0;
        courseCode="";
        courseTitle="";
        ectsCredits=0;
        gtuCredits=0;
        htl="";
    }

    /**
     *  The constructor give data create an objet
     * @param semester The Course Semester (Integer)
     * @param courseCode The Course Code (String)
     * @param courseTitle The Course Title (String)
     * @param ectsCredits The ECTS Credit of Course (Integer)
     * @param gtuCredits The GTU Credit of Course (Integer)
     * @param htl The H+T+L of Course (String)
     */
    public Course(int semester,String courseCode,String courseTitle,int ectsCredits,int gtuCredits,String htl){

        if(courseCode!=null && courseTitle!=null && htl!=null) {
            this.semester = semester;
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.ectsCredits = ectsCredits;
            this.gtuCredits = gtuCredits;
            this.htl = htl;
        }else {
            new Course();
        }
    }

    /**
     * The set operation of Course data
     * @param semester The Course Semester (Integer)
     * @param courseCode The Course Code (String)
     * @param courseTitle The Course Title (String)
     * @param ectsCredits The ECTS Credit of Course (Integer)
     * @param gtuCredits The GTU Credit of Course (Integer)
     * @param htl The H+T+L of Course (String)
     * @return Set operation is success return true else false
     */
    public boolean setCourse(int semester,String courseCode,String courseTitle,int ectsCredits,int gtuCredits,String htl){

        if(courseCode!=null && courseTitle!=null && htl!=null) {
            this.semester = semester;
            this.courseCode = courseCode;
            this.courseTitle = courseTitle;
            this.ectsCredits = ectsCredits;
            this.gtuCredits = gtuCredits;
            this.htl = htl;
            return true;
        }
        return false;
    }

    /**
     *  Get Semester
     * @return The Course Semester (Integer)
     */
    public int getSemester(){
        return semester;
    }

    /**
     *  Get Course Code
     * @return  The Course Code (String)
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     *  Get Course ECTS Credit
     * @return The ECTS Credit of Course (Integer)
     */
    public int getEctsCredits() {
        return ectsCredits;
    }

    /**
     * Get GTU Credis
     * @return The GTU Credit of Course (Integer)
     */
    public int getGtuCredits() {
        return gtuCredits;
    }

    /**
     *  Get Course Title
     * @return The Course Title (String)
     */
    public String getCourseTitle() {
        return courseTitle;
    }

    /**
     *  Get the H+T+L
     * @return The H+T+L of Course (String)
     */
    public String getHtl() {
        return htl;
    }

    /**
     *  The equals method for equals cehack object
     * @param obj the Course Object
     * @return if the object equal return true else false
     */
    @Override
    public boolean equals(Object obj) {

        if(obj!=null){
            Course c = (Course) obj;
            if(c.getSemester()==this.semester && c.getCourseCode().equals(courseCode) && c.getCourseTitle().equals(this.courseTitle))
                if(c.getEctsCredits()==this.ectsCredits && c.getGtuCredits()==this.gtuCredits && c.getHtl().equals(this.htl))
                    return true;
        }
        return false;
    }

    /**
     *  toString to Curse object
     * @return String of Course Object
     */
    @Override
    public String toString(){
        String str=new String("");
        // str = str.concat("Semester\tCourse Code\tCourse Title\tECTS Credits\tGTU Credits\tH+T+L\n");
        str = str.concat(semester+"\t"+courseCode+"\t"+courseTitle+"\t"+ectsCredits+"\t"+gtuCredits+"\t"+htl+"\n");
        return str;
    }
}
