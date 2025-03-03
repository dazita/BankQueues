package view;

import java.util.Scanner;

public class View {
    
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public void showList(String[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i]);
        }
    }

    public void close() {
        scanner.close();
    }
}
