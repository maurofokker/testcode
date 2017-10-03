package com.maurofokker.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mauro on 9/21/17.
 */
public class SolutionProblemOne {

    public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {

        int index = 0;
        boolean winner = false;
        String[] shoopingCartArr = new String[shoppingCart.size()];
        shoopingCartArr = (String[]) shoppingCart.toArray(shoopingCartArr);
        if (shoppingCart.size() == 0) return 0;
        outerloop:
        for(List<String> list : codeList) {
            System.out.println("list -> " + list);
            for (String item : list) {
                System.out.println("item -> " + item + " index: " + index + " shopping item en index -> " + shoopingCartArr[index]);
                if (item.equalsIgnoreCase(shoopingCartArr[index]) || "anything".equalsIgnoreCase(item)) {
                    winner = true;
                    System.out.println(winner);
                    index++;
                    System.out.println("index -> " + index + " largo arr " + shoopingCartArr.length);
                    if (index >= shoopingCartArr.length) {
                        break outerloop;
                    }
                } else {
                    winner = false;
                    System.out.println(winner);
                    break outerloop;
                }


            }
        }

        return winner ? 1 : 0;
    }

    public static void main(String [] args) {

        SolutionProblemOne solutionProblemOne = new SolutionProblemOne();

        List<List<String>> codeList = new ArrayList<List<String>>();
        List<String> code = new ArrayList<String>();
        code.add("orange");
        codeList.add(code);
        List<String> code2 = new ArrayList<String>();
        code2.add("apple");
        code2.add("apple");
        codeList.add(code2);
        List<String> code3 = new ArrayList<String>();
        code3.add("banaba");
        code3.add("orange");
        code3.add("apple");
        codeList.add(code3);
        List<String> code4 = new ArrayList<String>();
        code4.add("banana");
        codeList.add(code4);

        List<String> cart1 = new ArrayList<String>();
        cart1.add("orange");
        cart1.add("apple");
        cart1.add("apple");
        cart1.add("banana");
        cart1.add("orange");
        cart1.add("apple");
        cart1.add("banana");

        System.out.println("Salida 1: " + solutionProblemOne.checkWinner(codeList, cart1));

        List<List<String>> codeList2 = new ArrayList<List<String>>();
        List<String> code5 = new ArrayList<String>();
        code5.add("apple");
        code5.add("apricot");
        codeList2.add(code5);
        List<String> code6 = new ArrayList<String>();
        code6.add("banana");
        code6.add("anything");
        code6.add("guava");
        codeList2.add(code6);
        List<String> code7 = new ArrayList<String>();
        code7.add("papaya");
        code7.add("anything");
        codeList2.add(code7);

        List<String> cart2 = new ArrayList<String>();
        cart2.add("banana");
        cart2.add("orange");
        cart2.add("guava");
        cart2.add("apple");
        cart2.add("apricot");
        cart2.add("papaya");
        cart2.add("kiwi");
        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("Salida 2: " + solutionProblemOne.checkWinner(codeList2, cart2));

        List<String> cart3 = new ArrayList<String>();
        cart3.add("apple");
        cart3.add("apricot");
        cart3.add("banana");


        System.out.println("-------------------------------------");
        System.out.println("-------------------------------------");
        System.out.println("Salida 3: " + solutionProblemOne.checkWinner(codeList2, cart3));

    }

}
