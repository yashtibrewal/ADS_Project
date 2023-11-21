public class NoElementInHeapException extends Exception{
    
    NoElementInHeapException(){
        super("NoElementInHeapException: You attempted to remove an element from the heap with size 0");
    }

}
