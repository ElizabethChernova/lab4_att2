import org.example.StudentGradesSystem;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;


public class JUnitTest {

    //AssertJ
    @Tag("grade")
    @Test
    public void minGrade() {
        StudentGradesSystem st1 = new StudentGradesSystem(100,60,90,80,54 );
        int result = st1.findMin();
        //assertion
        assertThat(result).isEqualTo(54);
        assertThat(result).isNotEqualTo(60);
    }


//    @ParameterizedTest
//    @CsvSource({
//            "Harper Lee, 2",
//            "Winston Groom, 2",
//    })
//    public void testFindBooksByAuthor(String author, int expectedNumberOfBooks) {
//       // List<Book> foundBooks = bookController.findByAuthor(author);
//        assertEquals(expectedNumberOfBooks, 2, "Unexpected number of books found for author: ");
//    }
@Tag("grade")
    @ParameterizedTest
    @CsvSource({ "100, yes", " 4, no", "69, no" }) // Input and expected output pairs
    public void isTHisMaxGrade(int num1, String expectedAnswer) {
           StudentGradesSystem st1 = new StudentGradesSystem(100,60,90,80,54 );

String result="no";
        int grade = st1.findMax();
        if (grade==num1) result ="yes";
        assertEquals(expectedAnswer, result);
    }
//щоб була хоча б одна оцінка
@Tag("critical")
@TestFactory
public Stream<DynamicTest> isStudentPass() {

    StudentGradesSystem st1 = new StudentGradesSystem(100,67,90,80,94 );
    return st1.getGrades().stream()
            .map(grade -> dynamicTest("Test for " + grade, () -> {
                Assumptions.assumeTrue(grade <=100);
                assertTrue(grade >= 61);
            }));
}
}
