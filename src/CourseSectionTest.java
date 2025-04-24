import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CourseSectionTest {

    @Test   //T1
    void InitialStatePlanned() {
        CourseSection section = new CourseSection();
        assertEquals("Planned", section.getStatusFullName());
    }

    @Test   //T2
    void testOpenRegistration() {
        CourseSection section = new CourseSection();
        assertTrue(section.openRegistration());
    }

    @Test   //T3
    void testRequestToRegister() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        assertTrue(section.requestToRegister());
        assertEquals("Open",section.getStatusFullName() );
    }

    @Test   //T4
    void testClassSizeExceedsMaximum() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        assertTrue(section.classSizeExceedsMaximum());
        assertEquals("Closed",section.getStatusFullName() );
    }

    @Test   //T5
    void testCloseRegistration() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        assertTrue(section.closeRegistration());
        assertEquals("Closed",section.getStatusFullName());
    }

    @Test   //T6
    void testOpenToCancel() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        assertTrue(section.cancel());
        assertEquals("Cancelled",section.getStatusFullName() );
    }

    @Test   //T7
    void testPlanedToCancel() {
        CourseSection section = new CourseSection();
        assertTrue(section.cancel());
        assertEquals("Cancelled",section.getStatusFullName() );
    }

    @Test   //T8 Planned -> open -> Close "classSizeExceedsMaximum()" -> Cancelled
    void testClosedToCancel() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        section.classSizeExceedsMaximum();
        assertTrue(section.cancel());
        assertEquals("Cancelled", section.getStatusFullName());
    }

    @Test   //T9 Planned -> open -> Close "closeRegistration()" -> Cancelled
    void testClosedToCancel2() {
        CourseSection section = new CourseSection();
        section.openRegistration();
        section.closeRegistration();
        assertTrue(section.cancel());
        assertEquals("Cancelled",section.getStatusFullName() );
    }
}