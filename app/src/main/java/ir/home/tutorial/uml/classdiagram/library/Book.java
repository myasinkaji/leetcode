package ir.home.tutorial.uml.classdiagram.library;

import java.util.Set;

public class Book {
    private Set<Chapter> chapters;

    public class Chapter {
        private Book book;
    }
}
