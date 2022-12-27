package workshop;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PlaintextToHtmlConverter {
    String source;
    int i;
    List<String> result;
    List<String> convertedLine;
    String characterToConvert;

    public String toHtml() throws Exception {
        FileReader fileReader = new FileReader("sample.txt");
        String text = fileReader.readFile();
        String htmlLines = basicHtmlEncode(text);
        return htmlLines;
    }

    private String basicHtmlEncode(String source) {
        this.source = source;
        result = new ArrayList<>();
        convertedLine = new ArrayList<>();
        characterToConvert = getCharFormat();
        encodeChar();

        addANewLine();
        String finalResult = String.join("<br />", result);
        return finalResult;
    }

    private void encodeChar(){
        int i = 0;
        while (i <= this.source.length()) {
            switch (characterToConvert) {
                case "<":
                    convertedLine.add("&lt;");
                    break;
                case ">":
                    convertedLine.add("&gt;");
                    break;
                case "&":
                    convertedLine.add("&amp;");
                    break;
                case "\n":
                    addANewLine();
                    break;
                default:
                    pushChar();
            }

            if (i >= source.length()) break;

            characterToConvert = getCharFormat();
        }
    }


    private String getCharFormat() {
        char c = source.charAt(i);
        i += 1;
        return String.valueOf(c);
    }

    private void addANewLine() {
        String line = String.join("", convertedLine);
        result.add(line);
        convertedLine = new ArrayList<>();
    }

    private void pushChar() {
        convertedLine.add(characterToConvert);
    }
}
