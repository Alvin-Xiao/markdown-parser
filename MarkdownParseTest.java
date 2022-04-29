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
        Path fileName = Path.of("test-fileA.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("https://something.com", "some-thing.html");
        assertEquals(expected, links);
    }
    
    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("test-fileA2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("https:google.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("test-fileA3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("some-link.com", "some-link.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("test-fileA4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("some-link.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks5() throws IOException {
        Path fileName = Path.of("test-fileB.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("google.com");
        assertEquals(expected, links);
    }

    @Test
    public void testGetLinks6() throws IOException {
        Path fileName = Path.of("test-fileB2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse2.getLinks(content);
        List<String> expected = List.of("link.com", "link.com");
        assertEquals(expected, links);
    }
}
