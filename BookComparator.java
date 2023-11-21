import java.util.*;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        if(o1.getBookId() < o2.getBookId()){
            return -1;
        }else if(o1.getBookId() == o2.getBookId()){
            return 0;
        }else{
            return 1;
        }
    }
    
}
