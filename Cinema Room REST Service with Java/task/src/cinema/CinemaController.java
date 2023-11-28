package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {
    final Cinema cinema;

    public CinemaController(Cinema cinema) {
        this.cinema = cinema;
    }

    @GetMapping("/seats")
    public CinemaResponse getCinemaResponse() {
        return new CinemaResponse(cinema);
    }

    @PostMapping("/purchase")
    public SeatResponse checkAndPurchaseTicket(@RequestBody SeatRequest seatRequest) {
        for (Seat seat : cinema.getSeats()) {
            if (seat.getRow() == seatRequest.getRow() && seat.getColumn() == seatRequest.getColumn()) {
                if (!seat.isBooked()) {
                    seat.setBooked(true);
                    return new SeatResponse(seat.getRow(), seat.getColumn(), seat.getPrice());
                }
                throw new SeatNotAvailableException("The ticket has been already purchased!");
            }
        }
        throw new SeatNotFoundException("The number of a row or a column is out of bounds!");
    }
}
