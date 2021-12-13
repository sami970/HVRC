package bookingsystem.client.core;


import bookingsystem.client.model.BookingClientArea;
import bookingsystem.client.model.BookinClientAreaManager;

public class ModelFactory {

    private final ClientFactory cf;
    private BookingClientArea bookingClientArea;

    public ModelFactory(ClientFactory cf) {
        this.cf = cf;
    }

    public BookingClientArea getBookingClientArea() {
        if(bookingClientArea == null)
            bookingClientArea = new BookinClientAreaManager(cf.getClient());
        return bookingClientArea;
    }
}


