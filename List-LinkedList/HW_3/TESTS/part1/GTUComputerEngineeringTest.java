package part1;

import Part1.Course;
import Part1.GTUComputerEngineering;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GTUComputerEngineeringTest {

    private GTUComputerEngineering eng = new GTUComputerEngineering("src/Courses.csv");
    private Course course = new Course(1,"CSE 107","Introduction To Computer Science Laboratory",2,1,"0+0+2");
    @Test
    void getByCode() throws Exception {
        assertEquals(course,eng.getByCode("CSE 107").get(0));
    }

    @Test
    void listSemesterCourses() throws Exception {
        assertEquals(8,eng.listSemesterCourses(1).size());
    }

    @Test
    void getByRange() throws Exception {
        assertEquals(course,eng.getByRange(2,2).get(0));
    }
}