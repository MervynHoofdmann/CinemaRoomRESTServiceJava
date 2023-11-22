package cinema;

import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private int rows;
    private int columns;
    private List<Seat> seats = new ArrayList<>();

    public Cinema(int r, int c) {
        rows = r;
        columns = c;
        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                seats.add(new Seat(row, column));
            }
        }
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getRows() {
        return rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getColumns() {
        return columns;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
