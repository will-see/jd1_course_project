package entities;

public class Item {
    private long id;
    private long formularId;
    private int booksCount;

    public Item() {
    }

    public Item(long id, long formularId, int booksCount) {
        this.id = id;
        this.formularId = formularId;
        this.booksCount = booksCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getFormularId() {
        return formularId;
    }

    public void setFormularId(long formularId) {
        this.formularId = formularId;
    }

    public int getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(int booksCount) {
        this.booksCount = booksCount;
    }
}