package com.contacts;

import java.util.List;
import java.util.Scanner;

public class AgendaApp {
    private final Agenda agenda;
    private final Scanner scanner;

    public AgendaApp() {
        this.agenda = new Agenda();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        AgendaApp app = new AgendaApp();
        app.exibirMenu();
    }

    public void exibirMenu() {
        int option;
        do {
            System.out.println("\n--- Agenda Menu ---");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Search contact");
            System.out.println("4. List contacts");
            System.out.println("0. Exit");
            System.out.print("Chose a option: ");

            try {
                option = Integer.parseInt(scanner.nextLine());
                processarOpcao(option);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                option = -1; // Força repetição
            }

        } while (option != 0);
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                try {
                    addCont();
                } catch (InvalidEmail e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                removeCont();
                break;
            case 3:
                searchCont();
                break;
            case 4:
                agenda.listContacts();
                break;
            case 0:
                System.out.println("Finishing the program");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addCont() throws InvalidEmail {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contacts c = new Contacts();
        c.setName(name);
        c.setNumber(number);
        c.setEmail(email);

        if (Validator.emailValidator(c.getEmail())) {
            agenda.addContact(c);
            System.out.println("successfully added a contact!");
        } else {
            throw new InvalidEmail("Contact not saved. Invalid email");
        }
    }

    private void removeCont() {
        System.out.print("Removed contact's name: ");
        String name = scanner.nextLine();
        agenda.removeContact(name);
        System.out.println("Contact(s) removed(s) (if existed).");
    }

    private void searchCont() {
        System.out.print("Name to search: ");
        String name = scanner.nextLine();
        List<Contacts> found = agenda.searchContact(name);

        if (found.isEmpty()) {
            System.out.println("No contact found.");
        } else {
            for (Contacts c : found) {
                System.out.println("Name: " + c.getName());
                System.out.println("Number: " + c.getNumber());
                System.out.println("Email: " + c.getEmail());
                System.out.println("----------------------");
            }
        }
    }
}
// TODO: Implementar futuramente,validator telefone,implementar metodo para salvar no arquivo,carregar do arquivo,edicao de contato,excessao personalizada para o validator do numero,substituir loops por stream
        /*
        métodos para exportação e importação de arquivos de agenda
         */