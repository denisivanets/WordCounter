import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCounter {
    //TODO: change path
    private static final String filePath = "D:\\WordCounter\\resources\\text";
    private final Map<String, Integer> counter = new HashMap<>();

    public static void main(String[] args) throws Exception {
        WordCounter counter = new WordCounter();
        counter.readWords();
        counter.showWordsInfo();
    }

    private void readWords() throws Exception {
        List<String> allWords = new ArrayList<>();
        Files.lines(Paths.get(filePath))
                .forEach(words -> allWords.addAll(Arrays.asList(words.split(" "))));
        allWords.forEach(this::processWord);
    }

    private void processWord(String word) {
        if (!counter.containsKey(word)) {
            counter.put(word, 1);
        } else {
            counter.put(word, counter.get(word) + 1);
        }
    }

    private void showWordsInfo() {
        for (Map.Entry<String, Integer> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}
