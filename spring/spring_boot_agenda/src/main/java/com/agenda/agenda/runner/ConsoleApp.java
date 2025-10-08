package com.agenda.agenda.runner;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.service.ContactService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleApp implements CommandLineRunner {

    private final ContactService contactService;

    public ConsoleApp(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== AGENDA DE CONTATOS ===");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Deletar contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Nome: ");

                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Telefone: ");
                    String number = sc.nextLine();

                    Contact c = new Contact(name, email, number);
                    contactService.create(c);
                    System.out.println("Contato salvo com sucesso!");
                }
                case 2 -> {
                    List<Contact> contatos = contactService.listAll();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        contatos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("ID do contato: ");
                    Long id = sc.nextLong();
                    Contact c = contactService.findById(id);
                    System.out.println(c != null ? c : "Contato não encontrado!");
                }
                case 4 -> {
                    System.out.print("ID do contato a deletar: ");
                    Long id = sc.nextLong();
                    contactService.delete(id);
                    System.out.println("Contato deletado!");
                }
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }

        } while (option != 0);

        sc.close();
    }
}
