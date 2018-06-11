package com.xebia.exercice;

import com.xebia.exercice.elements.Grass;
import com.xebia.exercice.elements.Mower;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main( String [] args ) {
        List<Mower> mowers;

        System.out.println("standard configuration file ...");
        mowers = readConfigMower();


        for (Mower m : mowers) {
            System.out.println(m.getPositionX() + ", " + m.getPositionY() + ", " + m.getOrientation());
        }

        System.out.println("Json configuration file ...");
        mowers = readConfigMowerJson();

        for (Mower m : mowers) {
            System.out.println(m.getPositionX() + ", " + m.getPositionY() + ", " + m.getOrientation());
        }
    }

    private static List<Mower> readConfigMower() {

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("./config-mower");


        Grass grass = null;
        Mower mower = null;
        List<Mower> mowers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader( new InputStreamReader( inputStream ))) {
            String line;
            int nb = 0;
            while( (line = br.readLine()) != null ) {
                if( nb == 0 ) {
                    String[] elements = line.split(" ");
                    grass = new Grass( Integer.valueOf(elements[0]), Integer.valueOf(elements[1]) );
                } else if ( nb % 2 != 0 ) {
                    String[] elements = line.split(" ");
                    int x = Integer.valueOf(elements[0]);
                    int y = Integer.valueOf(elements[1]);
                    mower = new Mower(x, y, elements[2]);
                    mower.setGrass(grass);
                    mowers.add(mower);
                } else {
                    mower.move(line);
                }
                nb++;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mowers;
    }

    private static List<Mower> readConfigMowerJson() {

        List<Mower> mowers = new ArrayList<>();
        JSONObject jsonObject;

        try {
            String jsonData = readFile("config-mower.json");
            jsonObject = new JSONObject(jsonData);

            JSONObject jsonGrass = jsonObject.getJSONObject("grass");
            int x = jsonGrass.getInt("xMax");
            int y = jsonGrass.getInt("yMax");
            Grass grass = new Grass(x, y);

            JSONArray mowerList = (JSONArray) jsonObject.get("mowers");

            for( int i = 0; i < mowerList.length() ; i ++ ) {
                JSONObject jsonMower = mowerList.getJSONObject(i);
                int posX = jsonMower.getInt("positionX");
                int posY = jsonMower.getInt("positionY");
                String cardinal = jsonMower.getString("cardinal");

                Mower mower = new Mower(posX, posY, cardinal);
                mower.setGrass(grass);
                mower.move( jsonMower.getString("move") );

                mowers.add(mower);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mowers;
    }

    public static String readFile(String filename) {

        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(filename);
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader( new InputStreamReader( inputStream ))) {
            String line;
            int nb = 0;
            while( (line = br.readLine()) != null ) {
                result.append(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

}