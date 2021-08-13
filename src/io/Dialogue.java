package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dialogue {
    public static void main(String[] args) throws IOException {
        List<Personne> personneList = new ArrayList<>();
        Map<String, List<String>> dialogMap = new HashMap<>();
        try ( BufferedReader br = new BufferedReader( new FileReader("ressources/parlote.txt") ) ){

            br.readLine(); // skip first line

            String line = null;
            Personne p = null;
            boolean commentKeyPresent = false;
            //commnet official
            while ((line = br.readLine()) != null){

                if (line.contains(" -")){ // if that line is a dialog

                    if (dialogMap.containsKey(line.split(" ")[0])){//check if key already there

                        List<String> listDialog = dialogMap.get(line.split(" ")[0]);
                        listDialog.add(line.split(" - ")[1]);// add new dialog
                        dialogMap.put(line.split(" ")[0], listDialog);

                    }else{

                        List<String> listDialog = new ArrayList<>();
                        listDialog.add(line.split(" - ")[1]);
                        dialogMap.put(line.split(" ")[0],listDialog);

                    }

                }else{
                    if (!commentKeyPresent){// if there isn't comment yet

                        List<String> listComment = new ArrayList<>();
                        listComment.add(line);
                        dialogMap.put("Comment",listComment);
                        commentKeyPresent = true;

                    }else{

                        List<String> listComment = dialogMap.get("Comment");
                        listComment.add(line);// add new dialog
                        dialogMap.put("Comment", listComment);

                    }
                }

            }

            Set<String> allKeys = dialogMap.keySet();
            allKeys.forEach(name -> {
                List<String> elmntList = dialogMap.get(name);
                System.out.println("--- "+name+" ---");
                for (String s : elmntList)
                    System.out.println(s);
            });

        }catch(IOException ignored){}
    }
}
