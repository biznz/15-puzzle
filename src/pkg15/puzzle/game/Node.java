package pkg15.puzzle.game;


import pkg15.puzzle.Game;
import pkg15.puzzle.heuristic.Heuristic;

/**
 *
 * @author biz
 * 
 * class describes a node in a search graph.
 * It basically is a wrapper for a board configuration(State)
 * by implementing the Comparable interface Nodes can be 
 * compared
 */
public class Node implements Comparable<Node>{
    
    /**
     * PARENT_NODE is an object that describes the node that
     * spawned the this object
     * 
     */
    protected Node PARENT_NODE;
    /**
     * STATE is an object that describes the current
     * board configuration
     */
    protected State STATE;
    /**
     * OPERATOR is an object that describes the move
     * that lead to the current board configuration
     */
    protected Move OPERATOR;
    /**
     * DEPTH is an integer stating at which depth in
     * a search tree the node was generated
     * 
     */
    protected int DEPTH;
    /**
     * PATH_COST is an integer defining the search
     * path cost to reach it. The value is relevant
     * to search heuristic usage, default value should 
     * be the depth of the node
     * 
     */
    protected int PATH_COST;

    /**
     * constructor for Node used to define the 
     * ROOT of a search tree
     * @param state is a board configuration object
     */
    public Node(State state) {
        this.STATE = state;
        this.PARENT_NODE = null;
        this.OPERATOR = null;
        this.DEPTH = 0;
        this.PATH_COST = 0;
    }
    
    /**
     * 
     * @param parent is the parent node that this node was generated from
     * @param state is a board configuration object
     * @param move that lead to the current board configuration
     * @param depth at which this node is found in a given search tree
     * @param cost of reaching the node
     */
    public Node(Node parent, State state, Move move, int depth, int cost) {
        this.PARENT_NODE = parent;
        this.STATE = state;
        this.OPERATOR = move;
        this.DEPTH = depth;
        this.PATH_COST = cost;
    }
    
    /**
     * static function used to print a Node
     * @param node the node of a tree to pring
     * @return returns a string describing the game board
     */
    public static String result(Node node){
        int[][] puzzle = node.STATE.getPuzzle();
        String toPrint ="";
        for(int i=0;i<puzzle.length;i++){
            for(int s=0;s<puzzle.length;s++){
                toPrint+=" "+puzzle[i][s];
                //System.out.println(" "+puzzle[i][s]);
            }
            toPrint+="\n";
        }
        return toPrint;
    }

    public Node getPARENT_NODE() {
        return PARENT_NODE;
    }

    public State getSTATE() {
        return STATE;
    }

    public Move getOPERATOR() {
        return OPERATOR;
    }
    
    public String printMovement(){
        return this.OPERATOR.direction;
    }
    
    public int getDEPTH() {
        return DEPTH;
    }

    public int getPATH_COST() {
        return PATH_COST;
    }
    
    public void setPATH_COST(int cost){
        this.PATH_COST=cost;
    }
    
    /**
     * implementation of comparable interface compareTo method
     * @param o the node to compare to 
     * @return -1 if the Node can be found at higher depth
     * in a search tree than the compared to Node
     * 0 if both nodes game boards are the same configuration 
     */
    @Override
    public int compareTo(Node o) {
        if(equalPuzzle(this,o)){
            return 0;
        }
        else if (Game.heuristic!=null){
            int totalA=0;
            int totalB=0;
            for(Heuristic h: Algorithm.heuristic){
                if(!h.type.equals("pathcost")){
                    totalA = this.PATH_COST;
                    totalB = o.PATH_COST;
                }
            }
            if(totalA<=totalB){
                return -1;
            }
        }
        return 1;
    }
    
    /**
     * compares values in each of the board slots
     * to the ones from the compared to Node
     * helper function
     * @param a represents this node instance
     * @param b the node to compare to 
     * @return a boolean true if both nodes have the same board configuration
     *          false otherwise
     */
    private static boolean equalPuzzle(Node a,Node b){
        for(int s=0;s<a.STATE.getPuzzle().length;s++){
            for(int h=0;h<b.STATE.getPuzzle().length;h++){
                if(a.STATE.getPuzzle()[s][h]!=b.STATE.getPuzzle()[s][h]){
                    return false;
                }
            }
        }
        return true;
    }
    
}
