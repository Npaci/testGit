package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final String FILE_PATH = "ressources/games.csv";
    static List<Game> mainGamesList = new ArrayList<>();
    public static void main(String[] args) {
        //Demo read
        /*List<Personne> pers = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader( new FileReader("ressources/test.csv") ) ){

//            br.lines()
//                    .forEach(System.out::println);

            br.readLine(); // skip the title line

            String line;
            Personne p = null;
            while( (line = br.readLine()) != null ){
                p = new Personne();

                String[] values = line.split(",");

                p.setId( Long.parseLong(values[0]) );
                p.setPrenom( values[1] );
                p.setNom( values[2] );
                p.setEmail( values[3] );
                p.setProfession( values[4] );

                pers.add( p );
            }
        }
        catch (IOException ignored){}

        pers.forEach(System.out::println);*/

        //Demo Write
        //Lire le fichier de jeux
        List<Game> newGameList = new ArrayList<>();
        mainGamesList = readGamesFromCSV(FILE_PATH);

        if (mainGamesList == null){


            File myObj = new File(FILE_PATH);
            try (FileWriter myWriter = new FileWriter(FILE_PATH)) {
                mainGamesList = new ArrayList<>();

                addNewGame(newGameList);
                newGameList.forEach(System.out::println);
                System.out.println("On va sauvegarder!");
                saveGameCSV(newGameList, FILE_PATH);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{

            addNewGame(newGameList);
            newGameList.forEach(System.out::println);
            System.out.println("On va sauvegarder!");
            saveGameCSV(newGameList, FILE_PATH);
        }



    }

    public static void saveGameCSV(List<Game> gamesList, String filePath){

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))){

            bw.write("Id,Age,NbJoueurMin,NbJouerMax,Nom,Editeur");//Header
            bw.newLine();

            mainGamesList.addAll(gamesList);

            for (Game game : mainGamesList) {
                bw.write(game.getId()+","+game.getAge_min()+","+game.getNbr_joueur_min()+","+game.getNbr_joueur_max()+","+game.getNom()+","+game.getEditeur());
                bw.newLine();
            }
            System.out.println("Sauvegarde effectué avec succée !");
        }
        catch (IOException ex){
            System.out.println("Problème lors de la sauvegarde des jeux : ");
            ex.printStackTrace();
        }

    }

    public static List<Game> readGamesFromCSV(String fileName){

        List<Game> gameList = new ArrayList<>();

        try ( BufferedReader br = new BufferedReader( new FileReader(fileName) ) ){

            br.readLine();//skip first line
            String line = "";
            while ((line = br.readLine()) != null){
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                int ageMin = Integer.parseInt(parts[1]);
                int nbJoueurMin = Integer.parseInt(parts[2]);
                int nbJoueurMax = Integer.parseInt(parts[3]);
                String nom = parts[4];
                String editeur = parts[5];

                gameList.add( new Game(id, ageMin, nbJoueurMin, nbJoueurMax, nom, editeur) );

            }

        }catch (FileNotFoundException ex){
            gameList = null;
            System.out.println("Le fichier jeux n'existe pas encore");
            //ex.printStackTrace();
        }catch (IOException ex){
            gameList = null;
            System.out.println("Erreur lors de la lecture du fichier jeux");
            ex.printStackTrace();
        }

        return gameList;
    }

    public static void addNewGame(List<Game> gameList){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel est le nom du jeu?");
        String nom = scanner.nextLine();
        System.out.println("Quel est l'est l'éditeur de ce jeu?");
        String editeur = scanner.nextLine();
        System.out.println("Quel est l'age minimum'?");
        int age = scanner.nextInt();
        System.out.println("Quel est le nombre de joueur min?");
        int nbJourMin = scanner.nextInt();
        System.out.println("Quel est le nombre de joueur max?");
        int nbJourMax = scanner.nextInt();

        if (mainGamesList.size() == 0 && gameList.size() == 0)
            gameList.add( new Game(1, age, nbJourMin, nbJourMax, nom, editeur) );
        else if (mainGamesList.size() > 0 && gameList.size() == 0)
            gameList.add( new Game(mainGamesList.size() + 1, age, nbJourMin, nbJourMax, nom, editeur) );
        else // if (gameList.size() > 0)
            gameList.add( new Game(gameList.size() + 1, age, nbJourMin, nbJourMax, nom, editeur) );
    }
}
