package model;

import java.util.HashMap;
import config.*;

public class TicketAsigner {
    
    private PriorityQueue<Ticket> queue;
    private HashMap<String, Integer> processes;
    private int[] priorityCounter;

    public TicketAsigner(){
        SettingsConfig sc = new SettingsConfig();
        processes = sc.loadNames("src\\config\\config.txt");
        queue = new PriorityQueue<>(processes.size() + 1);
        priorityCounter = new int[processes.size() + 1];
    }

    public Ticket askTicket(int priority, boolean isPreferencial){
        if (isPreferencial) {
            priority = 0;
        }
        priorityCounter[priority]++;
        Ticket newTicket = new Ticket((char) ('A' + priority), priorityCounter[priority]);
        addTicketToQueue(newTicket, priority);
        return newTicket;
    }

    public void addTicketToQueue(Ticket ticket, int numericPriority){
        queue.push(ticket, numericPriority);
    }

    public String[] showProcesses(){
        return processes.keySet().toArray(new String[0]);
    }

    public Ticket callTicket(){
        if (queue.isEmpty()) {
            return null;
        }
        return queue.poll();
    }
}
