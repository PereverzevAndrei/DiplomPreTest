import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.canvas.parser.PdfTextExtractor;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {

        var doc = new PdfDocument(new PdfReader("pdfs/SoftSkills.pdf"));
        int pages = doc.getNumberOfPages();
        Map<String, Integer> freqs = new HashMap<>();//количество слов на странице
        Map<Integer, String> softSkills = new HashMap<>();//сохраняем распознанный текст постранично в мапу
        Map<Integer, String> freqsOnPages = new HashMap<>();
        for (int i = 1; i < pages; i++) {
            int actPage = i;
            PdfPage page = doc.getPage(i);
            var text = PdfTextExtractor.getTextFromPage(page);
            softSkills.put(i, text);}

        Iterator<Map.Entry<Integer, String>> iterator = softSkills.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> entry = iterator.next();
            Integer key = entry.getKey();
            String value = entry.getValue();

            var words = value.split("\\P{IsAlphabetic}+");
            for (var word : words) { // перебираем слова
                if (word.isEmpty()) {
                    continue;
                }
                word = word.toLowerCase();
                freqs.put(word, freqs.getOrDefault(word, 0) + 1);
            }
            freqsOnPages.put(key, String.valueOf(freqs));
        }
            //           doc.close();
        System.out.println(freqsOnPages.get(1));
        System.out.println(freqsOnPages.get(2));
        System.out.println(freqsOnPages.get(3));
        System.out.println(freqsOnPages.get(4));
        System.out.println(freqsOnPages.get(5));
        System.out.println(freqsOnPages.get(6));
        System.out.println(freqsOnPages.get(0));

    }
}

