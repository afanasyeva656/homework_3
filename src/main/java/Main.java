import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("voyna.txt");
        Parser parser = new Parser();
        ArrayList<String> list = null;
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Вхождение слова страдание
        int wordCount = getWordCount("страдани[иеяй].?", list);
        System.out.println("Число вхождений слова 'страдание': " + wordCount);

        // Использование Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для поиска:");
        String string = scanner.nextLine();
        wordCount = getWordCount(string, list);
        System.out.println("Число вхождений слова '" + string + "': " + wordCount);


        // Вывод таблицы умножения
        System.out.println("Вывод таблицы умножения: ");
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i*j + " ");
            }
            System.out.println("");
        }
    }


    private static int getWordCount(String wordPattern, ArrayList<String> list) {
        int wordCount = 0;
        if (list != null) {
            Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);

            for (String s : list) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    wordCount++;
                }
            }
        }
        return wordCount;
    }
}
