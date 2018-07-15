package part1;

import Part1.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {

    private Course course = new Course(1,"CSE101","Programlama",6,8,"2+0+1");

    @Test
    void setCourse() {
        assertEquals(true,course.setCourse(1,"CSE101"," Computer Progrramming",6,8,"2+0+1"));
    }

    @Test
    void getSemester() {
        assertEquals(1,course.getSemester());
    }

    @Test
    void getCourseCode() {
        assertEquals("CSE101",course.getCourseCode());
    }

    @Test
    void getEctsCredits() {
        assertEquals(6,course.getEctsCredits());
    }

    @Test
    void getGtuCredits() {
        assertEquals(8,course.getGtuCredits());
    }

    @Test
    void getCourseTitle() {
        assertEquals("Programlama",course.getCourseTitle());
    }

    @Test
    void getHtl() {
        assertEquals("2+0+1",course.getHtl());
    }

    @Test
    void equals() {
        assertEquals(false,course.equals(new Course()));
    }
}