package org.TomTom;

/**
 * Created by khatr on 25/06/2017.
 */
public class Factory {
    public MyFile getInstance(String InstanceType){
        if(InstanceType == null){
            return null;
        }
        if(InstanceType.equalsIgnoreCase("OpenFile")){
            return new OpenFile();

        } else if(InstanceType.equalsIgnoreCase("ReadFile")){
            return new ReadFile();

        }
        return null;
    }
}
