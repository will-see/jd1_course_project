import entities.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

    @Data
    @NoArgsConstructor
    public class FormularDto {
        private long id;
        private long userId;
        private List<Item> items = new ArrayList<>();
        private double total;
    }