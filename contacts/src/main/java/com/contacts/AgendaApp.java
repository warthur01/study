package com.contacts;

import java.util.List;
import java.util.Random;
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
                processOption(option);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
                option = -1; // Força repetição
            }

        } while (option != 0);
    }

    public void processOption(int option) {
        switch (option) {
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
        c.setId(new Random().nextInt());

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
        System.out.println("Choose a search method to find the contact:");
        System.out.println("1. Name");
        System.out.println("2. Number");
        System.out.println("3. Email");
        System.out.print("Option: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        System.out.print("Enter the search value: ");
        String value = scanner.nextLine();
        List<Contact> matches;

        switch (choice) {
            case 1:
                matches = agenda.searchContact(value);
                break;
            case 2:
                matches = agenda.searchByNumber(value);
                break;
            case 3:
                matches = agenda.searchByEmail(value);
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        if (matches.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Contact found:");
        for (Contact c : matches) {
            System.out.println("ID: " + c.getId());
            System.out.println("Name: " + c.getName());
            System.out.println("Number: " + c.getNumber());
            System.out.println("Email: " + c.getEmail());
            System.out.println("-------------------------");
        }
        Contact contact = matches.get(0);
    }


    private void editCont() throws InvalidEmailException, InvalidNumberException, NumberFormatException {
        System.out.println("Choose a search method to find the contact:");
        System.out.println("1. Name");
        System.out.println("2. Number");
        System.out.println("3. Email");
        System.out.print("Option: ");

        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        System.out.print("Enter the search value: ");
        String value = scanner.nextLine();
        List<Contact> matches;

        switch (choice) {
            case 1:
                matches = agenda.searchContact(value);
                break;
            case 2:
                matches = agenda.searchByNumber(value);
                break;
            case 3:
                matches = agenda.searchByEmail(value);
                break;
            default:
                System.out.println("Invalid option.");
                return;
        }

        if (matches.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        System.out.println("Contact found:");
        for (Contact c : matches) {
            System.out.println("ID: " + c.getId());
            System.out.println("Name: " + c.getName());
            System.out.println("Number: " + c.getNumber());
            System.out.println("Email: " + c.getEmail());
            System.out.println("-------------------------");
        }
        Contact contact = matches.get(0);


        System.out.println("\nEditing contact:");
        System.out.println("Current Name: " + contact.getName());
        System.out.println("Current Number: " + contact.getNumber());
        System.out.println("Current Email: " + contact.getEmail());


        agenda.removeContact(contact.getName());


        System.out.print("New Name (leave blank to keep): ");
        String newName = scanner.nextLine();
        if (!newName.isEmpty()) {
            contact.setName(newName);
        }

        System.out.print("New Number (leave blank to keep): ");
        String newNumber = scanner.nextLine();
        if (!newNumber.isEmpty()) {
            if (!Validator.phoneValidator(newNumber)) {
                throw new InvalidNumberException("Invalid number format.");
            }
            contact.setNumber(newNumber);
        }

        System.out.print("New Email (leave blank to keep): ");
        String newEmail = scanner.nextLine();
        if (!newEmail.isEmpty()) {
            if (!Validator.emailValidator(newEmail)) {
                throw new InvalidEmailException("Invalid email format.");
            }
            contact.setEmail(newEmail);
        }
        agenda.addContact(contact);
        System.out.println("Contact updated successfully!");
      /*  System.out.print("ID of the contact to edit: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new InvalidNumberException("Invalid id");
        }

        Contact contact = agenda.getContactById(id);

        if (contact == null) {
            System.out.println("No contact found with that ID.");
        } else {
            agenda.removeContactById(contact.getId());
            addCont(contact);


        }
        */
    }
}

// TODO: Implementar futuramente,implementar metodo para salvar no arquivo,carregar do arquivo,melhorar metodos find para buscar por email,nome,id,numero,mudar o uso de list para set
        /*
        métodos para exportação e importação de arquivos de agenda
         */