package services;

import entities.Pokemon;

import java.util.*;

public class Pokedex {

    private Map<Integer, Pokemon> mapPokemon;

    public Pokedex() {
        this.mapPokemon = new HashMap<>();
        loadData();
        System.out.print("Bem vindo treinador pokemon!\n");
    }

    public void addPokemon(Pokemon newPokemon) {
        this.mapPokemon.put(newPokemon.getId(), newPokemon);
    }

    public boolean removePokemon(int id) {
        return this.mapPokemon.remove(id) != null;
    }

    public Pokemon searchById(int id) {
        return this.mapPokemon.get(id);
    }

    public Pokemon searchByName(String name) {
        for (Pokemon p : mapPokemon.values()) {
            if (p.getName().equalsIgnoreCase(name.trim())) {
                return p;
            }
        }
        return null;
    }

    public List<Pokemon> searchByType(String type) {
        List<Pokemon> foundPokemons = new ArrayList<>();

        String searchType = type.trim().toLowerCase();

        for (Pokemon p : mapPokemon.values()) {
            if (p.getType().toLowerCase().contains(searchType)) {
                foundPokemons.add(p);
            }
        }
        return foundPokemons;
    }

    public Collection<Pokemon> listAll() {
        return this.mapPokemon.values();
    }

    private void loadData() {
        // STARTERS
        mapPokemon.put(1, new Pokemon(1, "Bulbasaur", "Grama/Veneno"));
        mapPokemon.put(2, new Pokemon(2, "Ivysaur", "Grama/Veneno"));
        mapPokemon.put(3, new Pokemon(3, "Venusaur", "Grama/Veneno"));
        mapPokemon.put(4, new Pokemon(4, "Charmander", "Fogo"));
        mapPokemon.put(5, new Pokemon(5, "Charmeleon", "Fogo"));
        mapPokemon.put(6, new Pokemon(6, "Charizard", "Fogo/Voador"));
        mapPokemon.put(7, new Pokemon(7, "Squirtle", "Água"));
        mapPokemon.put(8, new Pokemon(8, "Wartortle", "Água"));
        mapPokemon.put(9, new Pokemon(9, "Blastoise", "Água"));

        // INSETOS E AVES INICIAIS
        mapPokemon.put(10, new Pokemon(10, "Caterpie", "Inseto"));
        mapPokemon.put(11, new Pokemon(11, "Metapod", "Inseto"));
        mapPokemon.put(12, new Pokemon(12, "Butterfree", "Inseto/Voador"));
        mapPokemon.put(13, new Pokemon(13, "Weedle", "Inseto/Veneno"));
        mapPokemon.put(14, new Pokemon(14, "Kakuna", "Inseto/Veneno"));
        mapPokemon.put(15, new Pokemon(15, "Beedrill", "Inseto/Veneno"));
        mapPokemon.put(16, new Pokemon(16, "Pidgey", "Normal/Voador"));
        mapPokemon.put(17, new Pokemon(17, "Pidgeotto", "Normal/Voador"));
        mapPokemon.put(18, new Pokemon(18, "Pidgeot", "Normal/Voador"));
        mapPokemon.put(19, new Pokemon(19, "Rattata", "Normal"));
        mapPokemon.put(20, new Pokemon(20, "Raticate", "Normal"));
        mapPokemon.put(21, new Pokemon(21, "Spearow", "Normal/Voador"));
        mapPokemon.put(22, new Pokemon(22, "Fearow", "Normal/Voador"));

        // COBRAS E RATO ELÉTRICO
        mapPokemon.put(23, new Pokemon(23, "Ekans", "Veneno"));
        mapPokemon.put(24, new Pokemon(24, "Arbok", "Veneno"));
        mapPokemon.put(25, new Pokemon(25, "Pikachu", "Elétrico"));
        mapPokemon.put(26, new Pokemon(26, "Raichu", "Elétrico"));

        // TERRESTRES E ROCHOSOS
        mapPokemon.put(27, new Pokemon(27, "Sandshrew", "Terrestre"));
        mapPokemon.put(28, new Pokemon(28, "Sandslash", "Terrestre"));
        mapPokemon.put(29, new Pokemon(29, "Nidoran♀", "Veneno"));
        mapPokemon.put(30, new Pokemon(30, "Nidorina", "Veneno"));
        mapPokemon.put(31, new Pokemon(31, "Nidoqueen", "Veneno/Terrestre"));
        mapPokemon.put(32, new Pokemon(32, "Nidoran♂", "Veneno"));
        mapPokemon.put(33, new Pokemon(33, "Nidorino", "Veneno"));
        mapPokemon.put(34, new Pokemon(34, "Nidoking", "Veneno/Terrestre"));
        mapPokemon.put(35, new Pokemon(35, "Clefairy", "Fada"));
        mapPokemon.put(36, new Pokemon(36, "Clefable", "Fada"));
        mapPokemon.put(37, new Pokemon(37, "Vulpix", "Fogo"));
        mapPokemon.put(38, new Pokemon(38, "Ninetales", "Fogo"));
        mapPokemon.put(39, new Pokemon(39, "Jigglypuff", "Normal/Fada"));
        mapPokemon.put(40, new Pokemon(40, "Wigglytuff", "Normal/Fada"));
        mapPokemon.put(41, new Pokemon(41, "Zubat", "Veneno/Voador"));
        mapPokemon.put(42, new Pokemon(42, "Golbat", "Veneno/Voador"));

        // GRAMA E VENENO
        mapPokemon.put(43, new Pokemon(43, "Oddish", "Grama/Veneno"));
        mapPokemon.put(44, new Pokemon(44, "Gloom", "Grama/Veneno"));
        mapPokemon.put(45, new Pokemon(45, "Vileplume", "Grama/Veneno"));
        mapPokemon.put(46, new Pokemon(46, "Paras", "Inseto/Grama"));
        mapPokemon.put(47, new Pokemon(47, "Parasect", "Inseto/Grama"));
        mapPokemon.put(48, new Pokemon(48, "Venonat", "Inseto/Veneno"));
        mapPokemon.put(49, new Pokemon(49, "Venomoth", "Inseto/Veneno"));

        // ROCHOSOS E LUTADORES
        mapPokemon.put(50, new Pokemon(50, "Diglett", "Terrestre"));
        mapPokemon.put(51, new Pokemon(51, "Dugtrio", "Terrestre"));
        mapPokemon.put(52, new Pokemon(52, "Meowth", "Normal"));
        mapPokemon.put(53, new Pokemon(53, "Persian", "Normal"));
        mapPokemon.put(54, new Pokemon(54, "Psyduck", "Água"));
        mapPokemon.put(55, new Pokemon(55, "Golduck", "Água"));
        mapPokemon.put(56, new Pokemon(56, "Mankey", "Lutador"));
        mapPokemon.put(57, new Pokemon(57, "Primeape", "Lutador"));
        mapPokemon.put(58, new Pokemon(58, "Growlithe", "Fogo"));
        mapPokemon.put(59, new Pokemon(59, "Arcanine", "Fogo"));
        mapPokemon.put(60, new Pokemon(60, "Poliwag", "Água"));
        mapPokemon.put(61, new Pokemon(61, "Poliwhirl", "Água"));
        mapPokemon.put(62, new Pokemon(62, "Poliwrath", "Água/Lutador"));

        // PSÍQUICOS
        mapPokemon.put(63, new Pokemon(63, "Abra", "Psíquico"));
        mapPokemon.put(64, new Pokemon(64, "Kadabra", "Psíquico"));
        mapPokemon.put(65, new Pokemon(65, "Alakazam", "Psíquico"));

        // LUTADORES E ROCHOSOS
        mapPokemon.put(66, new Pokemon(66, "Machop", "Lutador"));
        mapPokemon.put(67, new Pokemon(67, "Machoke", "Lutador"));
        mapPokemon.put(68, new Pokemon(68, "Machamp", "Lutador"));
        mapPokemon.put(69, new Pokemon(69, "Bellsprout", "Grama/Veneno"));
        mapPokemon.put(70, new Pokemon(70, "Weepinbell", "Grama/Veneno"));
        mapPokemon.put(71, new Pokemon(71, "Victreebel", "Grama/Veneno"));
        mapPokemon.put(72, new Pokemon(72, "Tentacool", "Água/Veneno"));
        mapPokemon.put(73, new Pokemon(73, "Tentacruel", "Água/Veneno"));
        mapPokemon.put(74, new Pokemon(74, "Geodude", "Rocha/Terrestre"));
        mapPokemon.put(75, new Pokemon(75, "Graveler", "Rocha/Terrestre"));
        mapPokemon.put(76, new Pokemon(76, "Golem", "Rocha/Terrestre"));

        // PÔNEIS E ÁGUA
        mapPokemon.put(77, new Pokemon(77, "Ponyta", "Fogo"));
        mapPokemon.put(78, new Pokemon(78, "Rapidash", "Fogo"));
        mapPokemon.put(79, new Pokemon(79, "Slowpoke", "Água/Psíquico"));
        mapPokemon.put(80, new Pokemon(80, "Slowbro", "Água/Psíquico"));
        mapPokemon.put(81, new Pokemon(81, "Magnemite", "Elétrico/Aço"));
        mapPokemon.put(82, new Pokemon(82, "Magneton", "Elétrico/Aço"));
        mapPokemon.put(83, new Pokemon(83, "Farfetch'd", "Normal/Voador"));
        mapPokemon.put(84, new Pokemon(84, "Doduo", "Normal/Voador"));
        mapPokemon.put(85, new Pokemon(85, "Dodrio", "Normal/Voador"));
        mapPokemon.put(86, new Pokemon(86, "Seel", "Água"));
        mapPokemon.put(87, new Pokemon(87, "Dewgong", "Água/Gelo"));

        // FANTASMAS E PEDRAS
        mapPokemon.put(88, new Pokemon(88, "Grimer", "Veneno"));
        mapPokemon.put(89, new Pokemon(89, "Muk", "Veneno"));
        mapPokemon.put(90, new Pokemon(90, "Shellder", "Água"));
        mapPokemon.put(91, new Pokemon(91, "Cloyster", "Água/Gelo"));
        mapPokemon.put(92, new Pokemon(92, "Gastly", "Fantasma/Veneno"));
        mapPokemon.put(93, new Pokemon(93, "Haunter", "Fantasma/Veneno"));
        mapPokemon.put(94, new Pokemon(94, "Gengar", "Fantasma/Veneno"));
        mapPokemon.put(95, new Pokemon(95, "Onix", "Rocha/Terrestre"));

        // PSÍQUICOS E CRUSTÁCEOS
        mapPokemon.put(96, new Pokemon(96, "Drowzee", "Psíquico"));
        mapPokemon.put(97, new Pokemon(97, "Hypno", "Psíquico"));
        mapPokemon.put(98, new Pokemon(98, "Krabby", "Água"));
        mapPokemon.put(99, new Pokemon(99, "Kingler", "Água"));
        mapPokemon.put(100, new Pokemon(100, "Voltorb", "Elétrico"));
        mapPokemon.put(101, new Pokemon(101, "Electrode", "Elétrico"));
        mapPokemon.put(102, new Pokemon(102, "Exeggcute", "Grama/Psíquico"));
        mapPokemon.put(103, new Pokemon(103, "Exeggutor", "Grama/Psíquico"));
        mapPokemon.put(104, new Pokemon(104, "Cubone", "Terrestre"));
        mapPokemon.put(105, new Pokemon(105, "Marowak", "Terrestre"));

        // LUTADORES E FOGOS
        mapPokemon.put(106, new Pokemon(106, "Hitmonlee", "Lutador"));
        mapPokemon.put(107, new Pokemon(107, "Hitmonchan", "Lutador"));
        mapPokemon.put(108, new Pokemon(108, "Lickitung", "Normal"));
        mapPokemon.put(109, new Pokemon(109, "Koffing", "Veneno"));
        mapPokemon.put(110, new Pokemon(110, "Weezing", "Veneno"));
        mapPokemon.put(111, new Pokemon(111, "Rhyhorn", "Terrestre/Rocha"));
        mapPokemon.put(112, new Pokemon(112, "Rhydon", "Terrestre/Rocha"));
        mapPokemon.put(113, new Pokemon(113, "Chansey", "Normal"));
        mapPokemon.put(114, new Pokemon(114, "Tangela", "Grama"));
        mapPokemon.put(115, new Pokemon(115, "Kangaskhan", "Normal"));

        // ÁGUA E PEDRAS
        mapPokemon.put(116, new Pokemon(116, "Horsea", "Água"));
        mapPokemon.put(117, new Pokemon(117, "Seadra", "Água"));
        mapPokemon.put(118, new Pokemon(118, "Goldeen", "Água"));
        mapPokemon.put(119, new Pokemon(119, "Seaking", "Água"));
        mapPokemon.put(120, new Pokemon(120, "Staryu", "Água"));
        mapPokemon.put(121, new Pokemon(121, "Starmie", "Água/Psíquico"));
        mapPokemon.put(122, new Pokemon(122, "Mr. Mime", "Psíquico/Fada"));
        mapPokemon.put(123, new Pokemon(123, "Scyther", "Inseto/Voador"));
        mapPokemon.put(124, new Pokemon(124, "Jynx", "Gelo/Psíquico"));
        mapPokemon.put(125, new Pokemon(125, "Electabuzz", "Elétrico"));
        mapPokemon.put(126, new Pokemon(126, "Magmar", "Fogo"));
        mapPokemon.put(127, new Pokemon(127, "Pinsir", "Inseto"));
        mapPokemon.put(128, new Pokemon(128, "Tauros", "Normal"));

        // ÁGUA E VOADORES
        mapPokemon.put(129, new Pokemon(129, "Magikarp", "Água"));
        mapPokemon.put(130, new Pokemon(130, "Gyarados", "Água/Voador"));
        mapPokemon.put(131, new Pokemon(131, "Lapras", "Água/Gelo"));
        mapPokemon.put(132, new Pokemon(132, "Ditto", "Normal"));
        mapPokemon.put(133, new Pokemon(133, "Eevee", "Normal"));
        mapPokemon.put(134, new Pokemon(134, "Vaporeon", "Água"));
        mapPokemon.put(135, new Pokemon(135, "Jolteon", "Elétrico"));
        mapPokemon.put(136, new Pokemon(136, "Flareon", "Fogo"));
        mapPokemon.put(137, new Pokemon(137, "Porygon", "Normal"));

        // FÓSSEIS E LENDÁRIOS
        mapPokemon.put(138, new Pokemon(138, "Omanyte", "Rocha/Água"));
        mapPokemon.put(139, new Pokemon(139, "Omastar", "Rocha/Água"));
        mapPokemon.put(140, new Pokemon(140, "Kabuto", "Rocha/Água"));
        mapPokemon.put(141, new Pokemon(141, "Kabutops", "Rocha/Água"));
        mapPokemon.put(142, new Pokemon(142, "Aerodactyl", "Rocha/Voador"));
        mapPokemon.put(143, new Pokemon(143, "Snorlax", "Normal"));
        mapPokemon.put(144, new Pokemon(144, "Articuno", "Gelo/Voador"));
        mapPokemon.put(145, new Pokemon(145, "Zapdos", "Elétrico/Voador"));
        mapPokemon.put(146, new Pokemon(146, "Moltres", "Fogo/Voador"));
        mapPokemon.put(147, new Pokemon(147, "Dratini", "Dragão"));
        mapPokemon.put(148, new Pokemon(148, "Dragonair", "Dragão"));
        mapPokemon.put(149, new Pokemon(149, "Dragonite", "Dragão/Voador"));
        mapPokemon.put(150, new Pokemon(150, "Mewtwo", "Psíquico"));
        mapPokemon.put(151, new Pokemon(151, "Mew", "Psíquico"));
    }
}
