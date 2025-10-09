package com.agenda.agenda.runner;

import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.service.ContactService;
import com.agenda.agenda.validation.InvalidEmailException;
import com.agenda.agenda.validation.InvalidNumberException;
import com.agenda.agenda.validation.Validator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
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
            System.out.println("5 - Editar contato");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 0:
                    System.out.println("Saindo...");
                    break;

                case 1:
                    try {
                        System.out.print("Nome: ");
                        String name = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Telefone: ");
                        String number = sc.nextLine();

                        Contact c = new Contact(name, email, number);
                        contactService.create(c);
                        System.out.println("✅ Contato salvo com sucesso!");
                    } catch (InvalidEmailException | InvalidNumberException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case 2:
                    List<Contact> contatos = contactService.listAll();
                    if (contatos.isEmpty()) {
                        System.out.println("Nenhum contato encontrado.");
                    } else {
                        contatos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("ID do contato: ");
                    Long id = sc.nextLong();
                    Contact c3 = contactService.findById(id);
                    System.out.println(c3 != null ? c3 : "Contato não encontrado!");
                    break;

                case 4:
                    System.out.print("ID do contato a deletar: ");
                    Long idDel = sc.nextLong();
                    contactService.delete(idDel);
                    System.out.println("Contato deletado!");
                    break;

                case 5:
                    System.out.print("ID do contato a editar: ");
                    Long idEdit = sc.nextLong();
                    sc.nextLine();
                    Contact existing = contactService.findById(idEdit);

                    if (existing == null) {
                        System.out.println("❌ Contato não encontrado!");
                        break;
                    }

                    System.out.println("Editando contato: " + existing);
                    System.out.print("Novo nome (ou ENTER para manter): ");
                    String newName = sc.nextLine();
                    System.out.print("Novo email (ou ENTER para manter): ");
                    String newEmail = sc.nextLine();
                    System.out.print("Novo telefone (ou ENTER para manter): ");
                    String newNumber = sc.nextLine();

                    if (!newName.isBlank()) existing.setName(newName);
                    if (!newEmail.isBlank()) existing.setEmail(newEmail);
                    if (!newNumber.isBlank()) existing.setNumber(newNumber);

                    try {
                        contactService.update(existing);
                        System.out.println("✅ Contato atualizado com sucesso!");
                    } catch (InvalidEmailException | InvalidNumberException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (option != 0);

        sc.close();
    }
}
