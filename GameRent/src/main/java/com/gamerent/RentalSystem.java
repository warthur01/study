package com.gamerent;

import java.util.*;

import com.gamerent.InvalidEmailException;


public class RentalSystem {
    private static final List<Client> clients = new ArrayList<>();
    private static final List<Game> games = new ArrayList<>();
    private static final List<Rental> rentals = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("\n=== GAME RENT SYSTEM ===");
            System.out.println("1. REGISTER CLIENT");
            System.out.println("2. REGISTER GAME");
            System.out.println("3. REGISTER RENT");
            System.out.println("4. LIST CLIENTS");
            System.out.println("5. LIST GAMES");
            System.out.println("6. LIST RENTALS");
            System.out.println("0. LEAVE");
            System.out.print("Choose: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> registerClient();
                case 2 -> registerGame();
                case 3 -> makeRental();
                case 4 -> listClients();
                case 5 -> listGames();
                case 6 -> listRentals();
                case 0 -> System.out.println("Ending");
                default -> System.out.println("Invalid option!");
            }

        } while (option != 0);
    }


    private static void registerClient() {
        try {
            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Email: ");
            String email = scanner.nextLine();

            if (!isValidEmail(email)) {
                throw new InvalidEmailException("invalid email: " + email);
            }

            Client client = new Client(name, email);
            clients.add(client);
            System.out.println("Client registered successfully");

        } catch (InvalidEmailException e) {
            System.out.println("Registration error." + e.getMessage());
        }
    }


    private static void registerGame() {
        System.out.print("Title: ");
        String title = scanner.nextLine();

        Game game = new Game(title);
        games.add(game);
        System.out.println("Game registered successfully!");
    }

    private static void makeRental() {
        listGames();
        System.out.print("Client id: ");
        int clientId = scanner.nextInt();
        scanner.nextLine();

        Client foundClient = clients.stream()
                .filter(c -> c.getId() == clientId)
                .findFirst()
                .orElse(null);

        if (foundClient == null) {
            System.out.println("Client not found.");
            return;
        }

        System.out.print("Game name: ");
        String gameTitle = scanner.nextLine();


        Game foundGame = games.stream().filter(game -> game.getTitle().equalsIgnoreCase(gameTitle)).findFirst().orElse(null);
        if (foundGame == null) {
            System.out.println("Game not found.");
            return;

        }
        if (!foundGame.isAvailable()) {
            System.out.println("This game is already rented.");
            return;
        }
        foundGame.setAvailable(false);
        rentals.add(new Rental(foundClient, foundGame));
        System.out.println("Rent done successfully!");
    }

    private static void listRentals() {
        if (rentals.isEmpty()) {
            System.out.println("No rental located.");
            return;
        }

        System.out.println("\n--- Rentals ---");
        rentals.stream().forEach(System.out::println);
    }

    private static void listClients() {
        if (clients.isEmpty()) {
            System.out.println("No client registered.");
            return;
        }

        System.out.println("\n--- Client List ---");
        clients.stream().forEach(System.out::println);
    }
    
    private static void listGames() {
        if (games.isEmpty()) {
            System.out.println("No game registered.");
            return;
        }
        System.out.println("\n--- Game list ---");
        games.stream().forEach(System.out::println);
    }

    private static boolean isValidEmail(String email) {
        return email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$");
    }

}
