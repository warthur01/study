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
        int opcao;
        do {
            System.out.println("\n--- Agenda Menu ---");
            System.out.println("1. Add contact");
            System.out.println("2. Remove contact");
            System.out.println("3. Search contact");
            System.out.println("4. List contacts");
            System.out.println("0. Exit");
            System.out.print("Chose a option: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                processarOpcao(opcao);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
                opcao = -1; // Força repetição
            }

        } while (opcao != 0);
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarContato();
                break;
            case 2:
                removerContato();
                break;
            case 3:
                buscarContato();
                break;
            case 4:
                agenda.listContacts();
                break;
            case 0:
                System.out.println("Encerrando o programa...");
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private void adicionarContato() {
        System.out.print("Nome: ");
        String name = scanner.nextLine();
        System.out.print("Telefone: ");
        String number = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Contacts c = new Contacts();
        c.setName(name);
        c.setNumber(number);
        c.setEmail(email);

        agenda.addContact(c);
        System.out.println("successfully added a contact!");
    }

    private void removerContato() {
        System.out.print("Removed contact's name: ");
        String nome = scanner.nextLine();
        agenda.removeContact(nome);
        System.out.println("Contact(s) removed(s) (if existed).");
    }

    private void buscarContato() {
        System.out.print("Name to search: ");
        String nome = scanner.nextLine();
        List<Contacts> encontrados = agenda.searchContact(nome);

        if (encontrados.isEmpty()) {
            System.out.println("No contact found.");
        } else {
            for (Contacts c : encontrados) {
                System.out.println("Name: " + c.getName());
                System.out.println("Number: " + c.getNumber());
                System.out.println("Email: " + c.getEmail());
                System.out.println("----------------------");
            }
        }
    }
}