import java.util.ArrayList;
import java.util.List;

public class PageEntry implements Comparable<PageEntry> {
    private final String pdfName;
  //  private final String word;
    private final int page;
    private final int count;

    public int getCount() {
        return count;
    }

    public PageEntry(String pdfName, int page, int count) {
        this.count = count;
        this.page = page;
        this.pdfName = pdfName;
 //       this.word = word;
    }

    public List<PageEntry> search(String word) {
        List<PageEntry> searchResult = new ArrayList<>();
        return searchResult;
    }

    @Override
    public String toString() {
        return
                 pdfName +
                ", page=" + page +
                ", count=" + count
                ;
    }

    @Override
    public int compareTo (PageEntry o){
        if (this.getCount() > o.getCount()) return 1;
        if (this.getCount() < o.getCount()) return -1;
        else return 0;
    }


    // ???
}
