run:
		make clean
        javac GatorLibrary.java
		javac RedBlackTreeTest.java

clean:
        $(RM) *.class
		$(RM) *_output_file.txt
