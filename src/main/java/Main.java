import entities.Pokemon;
import services.Pokedex;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Pokedex servicePokedex = new Pokedex();

    public static void main(String[] args) {
        menu();
    }

    static int option(){
        System.out.print("""
                \n1 - Listar Pokemon
                2 - Buscar Pokemon
                3 - Buscar por Tipo
                4 - Adicionar Pokemon
                5 - Remover Pokemon
                0 - Sair
                """);
        return idChecker("Escolha uma opção: ");
    }

    static void menu() {
        while (true) {
            int option = option();
            switch (option) {
                case 0 -> {
                    System.out.print("\nEncerrando!");
                    System.exit(0);
                }
                case 1 -> listPokemon();
                case 2 -> searchPokemon();
                case 3 -> searchPokemonType();
                case 4 -> addPokemon();
                case 5 -> removePokemon();
                default -> System.out.print("Opcao Invalida");
            }
        }
    }

    static void listPokemon(){
        System.out.println("\n+++++++PokéDex+++++++");

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
        System.out.println("\nBuscar Pokémon...");
        System.out.print("Digite o ID, Nome: ");

        Pokemon found = null;
        String input = scanner.next();
        scanner.nextLine();

        try {
            int id = Integer.parseInt(input);
            found = servicePokedex.searchById(id);
        } catch (NumberFormatException e) {
            found = servicePokedex.searchByName(input);
        }

        if (found != null) {
            System.out.println("\n+++++++++++ ENCONTRADO +++++++++++");
            System.out.println(found);
            System.out.println("++++++++++++++++++++++++++++++++++");
        } else {
            System.out.println("\nPokémon de ID ou Nome " + input + " não encontrado.");
        }
    }

    static void searchPokemonType() {
        System.out.println("\nBuscar Pokemon por Tipo...");
        System.out.print("Tipo: ");

        String type = scanner.nextLine();

        List<Pokemon> foundPokemon = servicePokedex.searchByType(type);

        if (foundPokemon.isEmpty()) {
            System.out.println("Nenhum pokemon encontado.");
        } else {
            System.out.printf("Pokemons do tipo %s encontrados:\n", type);
            for (Pokemon pokemon : foundPokemon) {
                System.out.printf(" ID: %d | Nome: %s | Tipo: %s\n",
                        pokemon.getId(), pokemon.getName(), pokemon.getType());
            }
        }
    }

    static void addPokemon(){
        System.out.println("\nAdicionar Pokémon...");

        int id = idChecker("ID: ");
        if (servicePokedex.searchById(id) != null) {
            System.out.println("ID: " + id + "ja cadastrado.");
            return;
        }

        System.out.print("Nome: ");
        String name = scanner.nextLine().trim();
        if (servicePokedex.searchByName(name) != null) {
            System.out.println("Pokemon: " + name + "ja cadastrado.");
            return;
        }

        if (name.isEmpty()) {
            System.out.println("Favor, preenche corretamente o nome.");
            return;
        }

        System.out.print("Tipo: ");
        String type = scanner.nextLine().trim();
        if (type.isEmpty()) {
            System.out.println("Favor, preenche corretamente o nome.");
            return;
        }

        Pokemon newPokemon = new Pokemon(id, name, type);
        servicePokedex.addPokemon(newPokemon);

        System.out.println("\n" + name + " adicionado com sucesso!");
    }

    static void removePokemon(){
        System.out.println("\nRemover Pokémon...");
        System.out.print("Digite o ID ou Nome: ");

        Pokemon found = null;
        String input = scanner.next();
        scanner.nextLine();

        try {
            int id = Integer.parseInt(input);
            found = servicePokedex.searchById(id);
        } catch (NumberFormatException e) {
            found = servicePokedex.searchByName(input);
        }

        if (found == null) {
            System.out.println("\nErro: Pokémon de ID ou Nome " + input + " não encontrado para remoção.");
            return;
        }

        if (servicePokedex.removePokemon(found.getId())) {
            System.out.printf("\nPokémon %s ID: %d removido com sucesso", found.getName(), found.getId());
        } else {
            System.out.println("\nErro inesperado ao remover Pokémon.");
        }
    }

    static int idChecker(String prompt) {
        while (true) {
            System.out.print(prompt);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Erro: Não deixe o campo em branco.");
                continue;
            }

            try {
                int num = Integer.parseInt(input);
                if (num <= 0) {
                    System.out.println("Digite um valor valido.");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas numeros inteiros.");
            }
        }
    }
}
