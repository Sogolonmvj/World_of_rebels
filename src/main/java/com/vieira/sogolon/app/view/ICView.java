package com.vieira.sogolon.app.view;

import com.vieira.sogolon.app.controller.Rebel;
import com.vieira.sogolon.app.model.RebelTeam;
import lombok.Data;
import lombok.Getter;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

@Data
public class ICView {
    Scanner scan;

    @Getter
    private String joinTeam;

    @Getter
    private Rebel rebel;

    @Getter
    private RebelTeam team;

    @Getter
    private int index;

    public ICView() {
        this.scan = new Scanner(System.in);
        this.team = new RebelTeam();
    }

    public void welcome() throws FileNotFoundException, UnsupportedEncodingException {
        System.out.println("###########################################################");
        System.out.println("# Hello rebel! I am the administrator of the rebel world! #");
        System.out.println("###########################################################");
        this.addRebel();
    }

    public void addRebel() throws FileNotFoundException, UnsupportedEncodingException {
        boolean addMore = true;

        do {

            index = joinUs();

            switch (index) {
                case 1:
                    this.rebel = new Rebel();
                    rebel.askData();
                    newRebel();
                    break;
                case 2:
                    System.out.println("#: Ok! See you!");
                    addMore = false;
                    break;
                default:
                    System.out.println("#: Closing the application...");
                    addMore = false;
                    break;
            }

        } while (addMore);

    }

    private int joinUs() {
        System.out.println("#: Do you want to join us?");
        System.out.println("##########################");
        System.out.println("###: 1 - Yes # 2 - No ####");

        try {
            index = scan.nextInt();

            if (index != 1 && index != 2) {
                System.out.println("#: Enter a valid option, please!");
            }

        } catch (InputMismatchException e) {
            System.out.println("#: Invalid option!");
            index = 0;
        }

        return index;
    }

    private void newRebel() throws FileNotFoundException, UnsupportedEncodingException {
        joinTeam = String.valueOf(getRandomBoolean());

        switch (joinTeam) {
            case "true":
                team.newRebel(rebel);
                System.out.println("#: Rebel added to the team successfully!");
                team.printList();
                break;
            case "false":
                System.out.println("#: Unfortunately, you are not able to join us!");
                break;
            default:
                System.out.println("#: I am undecided!");
        }
    }

    private boolean getRandomBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }


}
