package view;

import Model.Ticket;
import java.util.List;

public interface ManagerListener {
    void updateTicketList(List<Ticket> ticketList);
}
