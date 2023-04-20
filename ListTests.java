import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.ArrayList;

public class ListTests {
    @Test
    public void testMerge() {
        ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("b");
        list2.add("c");
        list2.add("d");

        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("a", "b", "b", "c", "c", "d", "d"));

        assertEquals(expected, ListExamples.merge(list1, list2));
    }

    @Test
    public void testFilter() {
        StringChecker sc = new StringChecker() {
            public boolean checkString(String s) {
                return s.contains("a");
            }
        };

        ArrayList<String> list = new ArrayList<String>(
                Arrays.asList("apple", "beer", "car", "date", "egg", "fish", "grape"));

        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("apple", "car", "date", "grape"));

        assertEquals(expected, ListExamples.filter(list, sc));
    }
}
