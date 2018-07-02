package pkg15.puzzle.game;


/**
 *
 * @author b1z
 * 
 * class is used to represent state change 
 * through a play, a move in game
 * 
 * 
 */

public class Move {
    
    /**
     * a direction from which a game piece 
     * will be moved filling in the void 
     * slot in the puzzle
     */
    public String direction; 
    
    /**
     * movement constructor
     * @param direction solely describes a move
     */
    public Move(String direction){
        this.direction = direction;
    }
    
    /**
     * tests if a particular move is possible
     * @param state is a board configuration object
     * @param move is an action to perform on the current game state
     * @return a boolean indicating if a particular move is valid,
     *          true if it is, false if not
     */
    public static boolean test(State state,Move move){
        switch(move.direction){
            case "down":{
                if (state.getxBlankIndex()+1>=state.getPuzzle().length){return false;}
                break;
            }
            case "up":{
                if (state.getxBlankIndex()-1<0){return false;}
                break;
            }
            case "left":{
                if (state.getyBlankIndex()-1<0){return false;}
                break;
            }
            case "right":{
                if (state.getyBlankIndex()+1>=state.getPuzzle().length){return false;}
                break;
            }
        }
        return true;
    }
    
    /**
     * method recieves a game State, a Move and executes it outputing
     * a new game State
     * @param state is a board configuration object
     * @param move is an action to perform on the current game state
     * @return a resulting State after applying a move
     */
    public static State execute(State state,Move move){
        State newState = state;
        
        int tempVal,x,y;
        
        x = state.getxBlankIndex();
        y = state.getyBlankIndex();
        
        newState.setPuzzle(state.getPuzzle());
        
        if(!test(state,move)){return null;}
        switch(move.direction){
            case "down":{ // moving a piece down
                tempVal = state.getPuzzle()[x+1][y];
                newState.getPuzzle()[x+1][y]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x+1);
                newState.setyBlankIndex(y);
                break;
            }
            case "up":{ // moving a piece up
                tempVal = state.getPuzzle()[x-1][y];
                newState.getPuzzle()[x-1][y]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x-1);
                newState.setyBlankIndex(y);
                break;
            }
            case "left":{ // moving a piece left
                tempVal = state.getPuzzle()[x][y-1];
                newState.getPuzzle()[x][y-1]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x);
                newState.setyBlankIndex(y-1);
                break;
            }
            case "right":{ // moving a piece right
                tempVal = state.getPuzzle()[x][y+1];
                newState.getPuzzle()[x][y+1]=0;
                newState.getPuzzle()[x][y] = tempVal;
                newState.setxBlankIndex(x);
                newState.setyBlankIndex(y+1);
                break;
            }
        }
        return newState;
    }
    
}
