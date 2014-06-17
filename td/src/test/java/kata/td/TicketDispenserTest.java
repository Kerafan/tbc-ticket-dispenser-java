package kata.td;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by benwu on 14-6-10.
 */
public class TicketDispenserTest {
    @Test
    public void a_new_ticket_should_have_the_turn_number_subsequent_to_the_previous_ticket() {
        // Arrange
        TicketDispenser ticketDispenser = new TicketDispenser();
        TurnTicket previousTicket = ticketDispenser.getTurnTicket();

        // Act
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        // Assert
        assertEquals(1, newTicket.getTurnNumber() - previousTicket.getTurnNumber());
    }

    @Test
    public void a_new_ticket_should_have_the_turn_number_subsequent_to_the_previous_ticket_from_another_dispenser() {
        // Arrange
        TicketDispenser anotherTicketDispenser = new TicketDispenser();
        TicketDispenser ticketDispenser = new TicketDispenser();

        // Act
        TurnTicket previousTicket = anotherTicketDispenser.getTurnTicket();
        TurnTicket newTicket = ticketDispenser.getTurnTicket();

        // Assert
        assertEquals(1, newTicket.getTurnNumber() - previousTicket.getTurnNumber());
    }

    // TODO-unit-test-working-on: the class TicketDispenser should dispense the ticket number 11 if give a turn number 11 to it
    @Test
    public void the_class_TicketDispenser_should_dispense_the_ticket_number_11_if_give_a_turn_number_11_to_it() {
        // Arrange
        TurnNumberSequence mockTurnNumberSequence = mock(TurnNumberSequence.class);
        when(mockTurnNumberSequence.getNextTurnNumber()).thenReturn(11);
        TicketDispenser ticketDispenser = new TicketDispenser(mockTurnNumberSequence);

        // Act
        TurnTicket ticket = ticketDispenser.getTurnTicket();

        // Assert
        assertEquals(11, ticket.getTurnNumber());
        verify(mockTurnNumberSequence).getNextTurnNumber();
    }

    // TODO-new-feature: the turn number sequence of the vip customers starts from 1001
    // TODO-new-feature: the turn number sequence of the regular customers starts from 2001
}
