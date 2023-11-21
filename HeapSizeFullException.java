public class HeapSizeFullException extends Exception {
    
    HeapSizeFullException(){
        super("HeapSizeFullException: An element was tried to add to the full heap.");
    }

}
