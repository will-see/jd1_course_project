package entities;

public class Book {
    private long bookId;
    private String name;
    private String ganr;
    private int pages;
    private long authorId;
    private int bookCount;

    public Book() {
    }

    public Book(String name, String ganr, int pages, long authorId, int bookCount) {
        this.name = name;
        this.ganr = ganr;
        this.pages = pages;
        this.authorId = authorId;
        this.bookCount = bookCount;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGanr() {
        return ganr;
    }

    public void setGanr(String ganr) {
        this.ganr = ganr;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }
}
