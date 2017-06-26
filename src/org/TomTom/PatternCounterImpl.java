package org.TomTom;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by khatr on 25/06/2017.
 */
public class PatternCounterImpl implements PatternCounter {
    static Scanner reader = new Scanner(System.in);


    public String readFirstLine() {
        BufferedReader br;
        Factory factory = new Factory();
        MyFile openFile = factory.getInstance("OpenFile");
        MyFile readFile = factory.getInstance("ReadFile");

        String FILENAME = "";
        Boolean invalidPath = true, first = true;
        String text = "";
        do {
            if (first == true)
                System.out.print("Enter file path: ");
            else
                System.out.print("Please Enter the valid file path: ");
            FILENAME = reader.nextLine();
            File f = new File(FILENAME);
            if (f.exists() && !f.isDirectory()) {
                invalidPath = false;
                br = (BufferedReader) openFile.performOperation(FILENAME);
                text = (String) readFile.performOperation(br);
            }
            first = false;
        }
        while (invalidPath == true);

        return text;
    }

    public int readSecondLine() {
        int patternNum = 0;
        Boolean inValidPattern = true, firstNumCall = true;
        do {
            if (firstNumCall == true)
                System.out.println("Please Select the pattern you want from below: ");
            else
                System.out.println("You can only Select the pattern from below: ");
            System.out.println("Pattern 1: Counts occurrences of each unique word in the document ");
            System.out.println("Pattern 2: Counts occurrences of each unique number in the document ");
            System.out.println("Pattern 3: Counts occurrences of each unique phrase of three consecutive words in the document ");
            patternNum = reader.nextInt();
            if (patternNum < 4 && patternNum > 0)
                inValidPattern = false;
            firstNumCall = false;
        }
        while (inValidPattern == true);

        return patternNum;
    }

    public static boolean isInteger(String s) {
        boolean isValidInteger = false;
        try {
            Integer.parseInt(s);
            // s is a valid integer
            isValidInteger = true;
        } catch (NumberFormatException ex) {
            // s is not an integer
        }
        return isValidInteger;
    }

    public void patternOne(String text) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        String[] splited = text.split("\\s+");
        for (String str : splited) {
            if (isInteger(str)) {
                continue;
            } else {
                boolean contains = false;
                Iterator it = hm.entrySet().iterator();
                int n = 1;
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (pair.getKey().equals(str)) {
                        contains = true;
                        n = (int) pair.getValue();
                        n++;
                        pair.setValue(n);
                        break;
                    }
                }
                if (contains == false) {
                    hm.put(str, 1);
                }
            }
        }

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
    }

    public void patternTwo(String text) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        String[] splited = text.split("\\s+");
        for (String str : splited) {
            if (!isInteger(str)) {
                continue;
            } else {
                boolean contains = false;
                Iterator it = hm.entrySet().iterator();
                int n = 1;
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (pair.getKey().equals(str)) {
                        contains = true;
                        n = (int) pair.getValue();
                        n++;
                        pair.setValue(n);
                        break;
                    }
                }
                if (contains == false) {
                    hm.put(str, 1);
                }
            }
        }

        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
    }

    public void patternThree(String text) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        String[] singleSpaceSplited = text.split("\\s+");
        if (singleSpaceSplited.length < 3) {
            return;
        }
        String[] splited = new String[singleSpaceSplited.length - 2];
        int j = 0;
        for (int i = 0; i < singleSpaceSplited.length; i++) {
            if (singleSpaceSplited[i] == singleSpaceSplited[singleSpaceSplited.length - 2])
                break;
            splited[j] = singleSpaceSplited[i] + " " + singleSpaceSplited[i + 1] + " " + singleSpaceSplited[i + 2];
            j++;
        }

        for (String str : splited) {
            boolean contains = false;
            Iterator it = hm.entrySet().iterator();
            int n = 1;
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                if (pair.getKey().equals(str)) {
                    contains = true;
                    n = (int) pair.getValue();
                    n++;
                    pair.setValue(n);
                    break;
                }
            }
            if (contains == false) {
                hm.put(str, 1);
            }
        }
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println(pair.getKey() + ", " + pair.getValue());
        }
    }
    //FILENAME = "E:\\Tomtom\\input.txt";

    public static void main(String[] args) {

        PatternCounterImpl patternCounter = new PatternCounterImpl();

        String text = patternCounter.readFirstLine();
        int patterNum = patternCounter.readSecondLine();
        switch (patterNum) {
            case 1:
                patternCounter.patternOne(text);
                break;
            case 2:
                patternCounter.patternTwo(text);
                break;
            case 3:
                patternCounter.patternThree(text);
                break;
            default:
                System.out.println("Not 1, 2 or 3");
                break;
        }
    }
}
