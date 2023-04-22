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

        ArrayList<String> list3 = new ArrayList<String>(Arrays.asList("a", "b"));
        ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("c", "b", "a"));
        ArrayList<String> expected2 = new ArrayList<String>(Arrays.asList("a", "a", "b", "b", "c"));
        assertEquals(expected2, ListExamples.merge(list3, list4));
    }

    @Test
    public void testFilter() {
        StringChecker sc = new StringChecker() {
            public boolean checkString(String s) {
                return s.contains("a");
            }
        };

        ArrayList<String> failedList = new ArrayList<String>(
                Arrays.asList("apple", "beer", "car", "date", "egg", "fish", "grape"));
        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("apple", "car", "date", "grape"));
        assertEquals(expected, ListExamples.filter(failedList, sc));

        ArrayList<String> workingList = new ArrayList<String>(Arrays.asList("apple"));
        ArrayList<String> expected2 = new ArrayList<>(Arrays.asList("apple"));
        assertEquals(expected2, ListExamples.filter(workingList, sc));
    }
}
