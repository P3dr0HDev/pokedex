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
        System.out.print("Escolha uma opção: ");
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

    static void listarPokemon(){}

    static void buscarPokemon(){}

    static void adicionarPokemon(){}

    static void removerPokemon(){}
}
