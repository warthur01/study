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
        app.showMenu();
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Agenda Menu ---");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Search contact");
            System.out.println("4. List contacts");
            System.out.println("5. Edit contact");
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
                } catch (InvalidEmailException | InvalidNumberException e) {
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
            case 5:
                try {
                    editCont();
                } catch (InvalidEmailException | InvalidNumberException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                System.out.println("Finishing the program");
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addCont(Contact contact) throws InvalidEmailException, InvalidNumberException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (!name.isEmpty()) {
            contact.setName(name);
        }

        if (!number.isEmpty()) {
            contact.setNumber(number);
        }
        if (!email.isEmpty()) {
            contact.setEmail(email);
        }

        if (Validator.emailValidator(contact.getEmail()) && Validator.phoneValidator(contact.getNumber())) {
            agenda.addContact(contact);
            System.out.println("successfully saved a contact!");
        }

    }


    private void addCont() throws InvalidEmailException, InvalidNumberException {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contact c = new Contact();
        c.setName(name);
        c.setNumber(number);
        c.setEmail(email);

        if (Validator.emailValidator(c.getEmail()) && Validator.phoneValidator(c.getNumber())) {
            agenda.addContact(c);
            System.out.println("successfully saved a contact!");
        }
    }

    private void removeCont() {
        System.out.print("Removed contact's name: ");
        String name = scanner.nextLine();
        agenda.removeContact(name);
        System.out.println("Contact(s) removed(s) (if existed).");
    }

    private void removeCont(String name) {
        agenda.removeContact(name);
    }

    private void searchCont() {
        System.out.print("Name to search: ");
        String name = scanner.nextLine();
        List<Contact> found = agenda.searchContact(name);

        if (found.isEmpty()) {
            System.out.println("No contact found.");
        } else {
            found.stream().forEach(c -> {
                System.out.println("Name: " + c.getName());
                System.out.println("Number: " + c.getNumber());
                System.out.println("Email: " + c.getEmail());
                System.out.println("-------------------------");
            });
        }
    }

    private void editCont() throws InvalidEmailException, InvalidNumberException {
        System.out.print("Name of the contact to edit: ");
        String name = scanner.nextLine();

        List<Contact> found = agenda.searchContact(name);
        Contact contact = found.getFirst();

        if (contact == null) {
            System.out.println("No contact found with that name.");
        } else {
            removeCont(contact.getName());
            addCont(contact);
        }
    }
}
// TODO: Implementar futuramente,implementar metodo para salvar no arquivo,carregar do arquivo,criar id e implementar no programa,mudar o uso de list para set
        /*
        métodos para exportação e importação de arquivos de agenda
         */