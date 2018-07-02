package pkg15.puzzle.heuristic;

import pkg15.puzzle.Game;
import pkg15.puzzle.game.State;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author user
 */
public class ManHattan_Distance extends Heuristic{

    public ManHattan_Distance() {
        this.type = "manhattan";
    }

    
    
    
    @Override
    int calculate(State state) {
        int total_distance=0;
        int distance=0;
        int indexes[] = new int[2];
        //System.out.println(" Manhattan Heuristic distance ");
        //System.out.println(state.printPuzzle()+"\n on calculate");
        for(int h=0;h<state.getPuzzle().length;h++){
            distance = 0;
            for(int s=0;s<state.getPuzzle().length;s++){
                if(state.getPuzzle()[h][s]!=Game.gameMatrix[h][s] && state.getPuzzle()[h][s]!=0){
                    indexes = state.getpiecePos(state.getPuzzle()[h][s]);
                    distance+= (Math.abs(h-indexes[0])+Math.abs(s-indexes[1]));
                }
            }
            total_distance+=distance;
        }
        return total_distance;
    }
    
}
