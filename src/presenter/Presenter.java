package presenter;

import model.Ticket;
import model.TicketAsigner;
import view.*;

public class Presenter {
    
    public View view;
    public TicketAsigner ta;

    public Presenter() {
        run();
    }

    public void run(){
        view = new View();
        ta = new TicketAsigner();
        int i = 0;
        while(i == 0){
            showMenu();
            int process = Integer.valueOf(view.getInput("DIGITE EL VALOR DEL TRÁMITE A REALIZAR"));
            if (process == 0) {
                view.showMessage("vuelva pronto");
                break;
            }
            if (process == 1212) {
                Ticket ticket = ta.callTicket();
                if (ticket == null) {
                    view.showMessage("no hay turnos :(");
                } else {  
                    view.showMessage("Turno: " + ticket.getPriority() + " " + ticket.getPosition());
                }
            } else {
                view.showMessage("es una persona embarazada o en condicion de discapacidad?");
                view.showList(new String[]{"Si", "No"});
                int isPreferencial = Integer.valueOf(view.getInput("digite su respuesta"));
                boolean isPreferencialboolean = false;
                if (isPreferencial == 1) {
                    isPreferencialboolean = true;
                }
                Ticket ticket = ta.askTicket(process, isPreferencialboolean);
                view.showMessage("su turno es " + ticket.getPriority() + " " + ticket.getPosition());
            }
        }
    }

    public void showMenu(){
        view.showMessage("0. Salir");
        view.showList(ta.showProcesses());
    }
}
