package model;
public class Ticket {
    
    private char priority;
    private int position;

    public Ticket(char priority, int position) {
        this.priority = priority;
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public char getPriority() {
        return priority;
    }
}
