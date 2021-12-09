package com.example.appbasica;

import java.util.*;
import java.nio.charset.*;
public class IDGenerator {
    public IDGenerator() {
    }

    static String getRandomString(int i){
            // bind the length
            byte[] bytearray;
            bytearray = new byte[256];
            String mystring;
            StringBuffer thebuffer;
            String theAlphaNumericS;

            new Random().nextBytes(bytearray);

            mystring = new String(bytearray, StandardCharsets.UTF_8);
            thebuffer = new StringBuffer();

            //remove all spacial char
            theAlphaNumericS = mystring.replaceAll("[^A-Z0-9]", "");

            //random selection
            for (int m = 0; m < theAlphaNumericS.length(); m++) {

                if (Character.isLetter(theAlphaNumericS.charAt(m)) && (i > 0) || Character.isDigit(theAlphaNumericS.charAt(m)) && (i > 0)) {
                    thebuffer.append(theAlphaNumericS.charAt(m));
                    i--;
                }
            }
            // the resulting string
            return thebuffer.toString();
        }
}