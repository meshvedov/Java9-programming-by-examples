package mic.java9.by.example.mastermind;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Table {
    final ColorManager manager;
    final int nrColumns;
    final List<Row> rows;

    public Table(int nrColumns, ColorManager manager) {
        this.nrColumns = nrColumns;
        this.manager = manager;
        this.rows = new CopyOnWriteArrayList<>();
    }

    public int nrOfColumns() {
        return nrColumns;
    }

    public void addRow(Row row) {
        rows.add(row);
    }
}
