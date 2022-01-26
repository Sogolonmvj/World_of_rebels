package com.vieira.sogolon.app.model;

import com.vieira.sogolon.app.controller.Rebel;
import lombok.Cleanup;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class RebelTeam {
    private List<Rebel> accepted;

    public RebelTeam() {
        accepted = new ArrayList<>();
    }

    public void newRebel(Rebel rebel) {
        accepted.add(rebel);
    }

    public void printList() throws FileNotFoundException, UnsupportedEncodingException {
        @Cleanup PrintWriter writer = new PrintWriter("Accepted-rebels.txt", "UTF-8");
        writer.println("List of accepted rebels: ");
        writer.println("");

        for (Rebel rebel : accepted ) {
            writer.println(rebel);
        }
    }
}
