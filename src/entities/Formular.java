package entities;

import java.util.ArrayList;
import java.util.List;

public class Formular {
        private long formularId;
        private long userId;
        private List<Item> items = new ArrayList<>();
        private long bookId;

    public Formular() {
    }

    public long getFormularId() {
        return formularId;
    }

    public void setFormularId(long formularId) {
        this.formularId = formularId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }
}
