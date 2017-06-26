package org.TomTom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static javax.script.ScriptEngine.FILENAME;

/**
 * Created by khatr on 25/06/2017.
 */
public class OpenFile implements MyFile{
    BufferedReader br;

    @Override
    public Object performOperation(Object input) {
        try {
            br=new BufferedReader(new FileReader((String)input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }
}
