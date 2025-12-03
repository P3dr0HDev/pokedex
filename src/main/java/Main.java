import entities.Pokemon;
import services.Pokedex;

import java.util.Collection;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Pokedex servicePokedex = new Pokedex();

    public static void main(String[] args) {
        menu();
    }

    static int option(){
        System.out.print("""
                1 - Listar Pokemon
                2 - Buscar Pokemon
                3 - Adicionar Pokemon
                4 - Remover Pokemon
                0 - Sair
                """);
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    static void menu() {
        while (true) {
            int option = option();
            switch (option) {
                case 0 -> {
                    System.out.print("Encerrando!");
                    System.exit(0);
                }
                case 1 -> listPokemon();
                case 2 -> searchPokemon();
                case 3 -> addPokemon();
                case 4 -> removePokemon();
                default -> System.out.print("Opcao Invalida");
            }
        }
    }

    static void listPokemon(){
        System.out.println("+++++++PokéDex+++++++");

        Collection<Pokemon> pokemons = servicePokedex.listAll();

        if (pokemons.isEmpty()) {
            System.out.println("Nenhum Pokémon encontrado.");
            return;
        }

        for (Pokemon pokemon : pokemons) {
            System.out.printf(" ID: %d | Nome: %s | Tipo: %s\n",
                    pokemon.getId(), pokemon.getName(), pokemon.getType());
        }
    }

    static void searchPokemon(){
        System.out.println("Buscar Pokémon...\n");

        System.out.print("Digite o ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Erro: ID deve ser um número.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        Pokemon found = servicePokedex.searchById(id);

        if (found != null) {
            System.out.println("\n+++++++ ENCONTRADO +++++++");
            System.out.println(found);
            System.out.println("++++++++++++++++++++++++++");
        } else {
            System.out.println("\nPokémon com ID " + id + " não encontrado.");
        }
    }

    static void addPokemon(){
        System.out.println("Adicionar Pokémon...\n");

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String name = scanner.nextLine();

        System.out.print("Tipo: ");
        String type = scanner.nextLine();

        Pokemon newPokemon = new Pokemon(id, name, type);
        servicePokedex.addPokemon(newPokemon);

        System.out.println("\n" + name + " adicionado com sucesso!");
    }

    static void removePokemon(){
        System.out.println("Remover Pokémon...\n");

        System.out.print("Digite o ID: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Erro: ID deve ser um número.");
            scanner.nextLine();
            return;
        }

        int id = scanner.nextInt();
        scanner.nextLine();

        if (servicePokedex.removePokemon(id)) {
            System.out.println("\nPokémon com ID " + id + " removido com sucesso.");
        } else {
            System.out.println("\nErro: Pokémon com ID " + id + " não encontrado para remoção.");
        }
    }
}
