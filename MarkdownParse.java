//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

// This edit was made to test whether it can be committed and pushed to the repository
// Another edit
public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        ArrayList<Integer> indexTracker = new ArrayList<>();
        while(currentIndex < markdown.length()) {

            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            indexTracker.add(closeParen);
            
            if (openBracket - 1 == markdown.indexOf("!", currentIndex) && openBracket != 0) {
                currentIndex = closeParen + 1;
            }
            else {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }

            for(int i = 0; i < indexTracker.size(); i++) {
                if (i + 1 < indexTracker.size()) {
                    if (indexTracker.get(i).equals(indexTracker.get(i + 1))) {
                        currentIndex = markdown.length();
                        toReturn.remove(toReturn.size() - 1);
                    }
                }
            }
        }

        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}