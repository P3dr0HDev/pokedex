import entities.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static List<Pokemon> pokedex = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    static int opcao(){
        System.out.print("""
                1 - Listar Pokemon
                2 - Buscar Pokemon
                3 - Adicionar Pokemon
                4 - Remover Pokemon
                0 - Sair
                """);
        System.out.print("Escolha uma opção: \n");
        return scanner.nextInt();
    }

    static void menu() {
        while (true) {
            int opcao = opcao();
            switch (opcao) {
                case 0 -> {
                    System.out.print("Encerrando!");
                    System.exit(0);
                }
                case 1 -> listarPokemon();
                case 2 -> buscarPokemon();
                case 3 -> adicionarPokemon();
                case 4 -> removerPokemon();
            }
        }
    }

    static void listarPokemon(){
        System.out.println("+++++++PokéDex+++++++");

        for (int i = 0; i < pokedex.size(); i++) {
            Pokemon pokemon = pokedex.get(i);
            System.out.printf("""
                    +++++++++++++++
                        Índice: %d
                        Nome: %s
                        +++++++++++++++
                    """, i, pokemon.getName());
        }
        menu();

    }

    static void buscarPokemon(){
        System.out.println("Buscar Pokémon...\n");
        if (pokedex.isEmpty()) {
            System.out.println("Nenhum Pokémon encontrado\n");
            return;
        }
        System.out.println("Pokémon: ");
        String search = scanner.nextLine().toLowerCase().trim();

        for (int i = 0; i < pokedex.size(); i++) {
            Pokemon pokemon = pokedex.get(i);

            if (pokemon.getName().toLowerCase().contains(search)) {
                System.out.printf("""
                        +++++++++++++++
                        Índice: %d
                        Nome: %s
                        +++++++++++++++
                        """, i, pokemon.getName());
            }
        }
        menu();

    }

    static void adicionarPokemon(){}

    static void removerPokemon(){}
}
