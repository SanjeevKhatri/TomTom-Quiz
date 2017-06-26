package org.TomTom;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by khatr on 25/06/2017.
 */
public class ReadFile implements MyFile{

    private String sCurrentLine, helper="";
    @Override
    public Object performOperation(Object input) {

        BufferedReader br= (BufferedReader)input;
        try {
            while ((sCurrentLine = br.readLine()) != null) {
                helper+=sCurrentLine +"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return helper;
    }
}
