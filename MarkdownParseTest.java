import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https://something.com", "some-thing.html");
        assertEquals(expected, links);
    }
    
    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("https:google.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("some-link.com", "some-link.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        List<String> expected = List.of("some-link.com");
        assertEquals(expected, links);
    }
}