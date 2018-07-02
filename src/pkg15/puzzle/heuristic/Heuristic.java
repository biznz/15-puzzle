package pkg15.puzzle.heuristic;

import pkg15.puzzle.game.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
public abstract class Heuristic {
    int value;
    String type;
    abstract int calculate(State state);
}
