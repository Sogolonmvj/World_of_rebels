package com.vieira.sogolon.app;

import com.vieira.sogolon.app.view.ICView;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        ICView central = new ICView();
        central.welcome();
    }

}
