/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg15.puzzle.view;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author biznz
 */
public class GameMenu {
    
    private TreeMap<Integer,String> options;
    private int lvl;
    private int chosenOption;
    private String prompt;
     private HashMap<String,String> puzzles;
    
    
    /**
     * set of test cases add more cases to the map and to case 0 in menu
     */
    
    private String teste1 = "1 2 3 4 5 0 7 8 9 6 10 12 13 14 11 15"; //solution at depth 4
    private String final1 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
    
    private String teste2 = "9 12 0 7 14 5 13 2 6 1 4 8 10 15 3 11"; //solution at depth 13
    private String final2 = "9 5 12 7 14 13 0 8 1 3 2 4 6 10 15 11";
    
    private String teste3 = "6 12 0 9 14 2 5 11 7 8 4 13 3 10 1 15"; //solution at depth 8
    private String final3 = "14 6 12 9 7 2 5 11 8 4 13 15 3 10 1 0";
    
    private String teste4 = "1 2 3 4 5 6 7 0 9 10 11 8 13 14 15 12"; //solution at depth 2
    private String final4 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0";
    
    /**
     * 
     * @param level 
     */
    
    public GameMenu(int level){
        options = new TreeMap<Integer,String>();
        this.lvl = level;
        switch(level){
            case 0:{
                puzzles = new HashMap<String,String>();
                puzzles.put("teste1", teste1);
                puzzles.put("final1", final1);
                puzzles.put("teste2", teste2);
                puzzles.put("final2", final2);
                puzzles.put("teste3", teste3);
                puzzles.put("final3", final3);
                puzzles.put("teste4", teste4);
                puzzles.put("final4", final4);
                options.put(1,"["+teste1+"]  solution at depth 4"+"\n   ["+final1+"]\n");
                options.put(2,"["+teste2+"] solution at depth 13"+"\n   ["+final2+"]\n");
                options.put(3,"["+teste3+"] solution at depth 8"+"\n   ["+final3+"]\n");
                options.put(4,"["+teste4+"] solution at depth 2"+"\n   ["+final4+"]\n");
                options.put(options.size()+1,"Insert a new puzzle and goal");
                options.put(options.size()+1, "exit");
                this.prompt = "Select a puzzle and goal state, or, give it your own puzzle \n";
                break;
            }
            case 1:{
                options.put(1, "Depth First Search");
                options.put(2, "Breadth First Search");
                options.put(3, "Iterative Deepening Depth-First Search");
                options.put(4, "A*");
                options.put(5, "Greedy");
                options.put(6, "Check if input is Solvable");
                options.put(7, "exit");
                this.prompt = "Select one of the following options\n";
                break;
            }
            case 2:{
                this.prompt = "Introduce puzzle initial state and goal state\n";
                break;
            }
            case 3:{
                this.prompt = "Please insert a depth limit";
                options.put(1,"depth limit 15");
                options.put(2,"depth limit 20");
                options.put(3,"depth limit 30");
                options.put(4,"depth limit 40");
                options.put(5,"no depht limit");
                break;
            }
            
        }
    }
        
}
