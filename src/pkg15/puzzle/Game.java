package pkg15.puzzle;



import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import pkg15.puzzle.game.Move;
import pkg15.puzzle.game.Node;
import pkg15.puzzle.game.Problem;
import pkg15.puzzle.game.State;



/**
 *
 * @author biznz
 */
public class Game {
    
    public static int[][] gameMatrix= {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
    
    public static gamePath = 
    
    static Set<Move> moves = new HashSet<Move>(
            Arrays.asList(
                    new Move("up"),
                    new Move("down"),
                    new Move("left"),
                    new Move("right") 
            ));
    
    
    public static void main(String[] args){
        
    }
    
    public static Node REMOVE_FRONT(AbstractCollection<Node> nodes){
        Node result=null;
        Class lifo = java.util.Stack.class;
        Class fifo = java.util.LinkedList.class;
        Class heap = java.util.PriorityQueue.class;
        if(!nodes.isEmpty()){
            if(nodes.getClass().equals(lifo)){
                Stack<Node> s = (Stack<Node>)nodes;
                result=s.pop();
                }
            if(nodes.getClass().equals(fifo)){
                LinkedList<Node> l = (LinkedList<Node>)nodes;
                result=l.removeFirst();
            }
            if(nodes.getClass().equals(heap)){
                PriorityQueue<Node> h = (PriorityQueue<Node>)nodes;
                result=h.poll();
            }
        }
        return result;
    }
    
    public static State GOAL_TEST(Problem problem){
        return new State(problem);
    }
    
    
    public static Node MAKE_NODE(State state){
        Node node = new Node(state);
        return node;
    }
    
    public static AbstractCollection<Node> MAKE_QUEUE(AbstractCollection<Node> queue,Node node){
        //currentDepth = new Integer(0);
        queue.add(node);
        return queue;
    }
    
    public static State INITIAL_STATE(Problem problem) {
        State state = new State(problem);
        return state;
    }
    
    public static State STATE(Node node){
        if(node==null){return null;}
        return node.getSTATE();
    }
    
    public static boolean SOLVABLE(Problem initialProblem, Problem finalProblem){
        return (checkSolvable(initialProblem) && checkSolvable(finalProblem));
    }
    
    public static Set<Move> OPERATORS(){
        return moves;
    }
    
    public static boolean EMPTY(AbstractCollection<Node> nodes){
        return nodes.isEmpty();
    }
    
    private static boolean checkSolvable(Problem problem){
        int totalInversions=0;
        int blank=-1;
        int numRows = (int) Math.sqrt(problem.input.length);
        int position=0;
        for(int s=0;s<problem.input.length;s++){
            int inversions=0;
            if(problem.input[s]==0){
                blank = numRows-(s/numRows);
            }
            for(int h=position;h<problem.input.length;h++){
                if(problem.input[s]>problem.input[h] && problem.input[s]!=0 && problem.input[h]!=0){
                    inversions+=1;
                }
            }
            position+=1;
            totalInversions+=inversions;
        }
        return ((problem.input.length%2!=0 && totalInversions%2==0)) || ((problem.input.length%2==0) && ((blank%2==1) == (totalInversions%2==0)));
    }
    
    public static Set<Node> EXPAND(Node node,Set<Move> movements){
        Set<Node> childNodes = new HashSet<Node>();
        if(maxDepth!=null && node.getDEPTH()+1>maxDepth){
            return null;
        }
        currentDepth = new Integer(node.getDEPTH()+1);
        for(Move m:movements){
            if(Move.test(node.getSTATE(), m)){
                State newState = new State(node.getSTATE().getPuzzle());
                newState = Move.execute(newState, m);
                if(newState!=null){
                    Node newNode = new Node(node,newState,m,node.getDEPTH()+1,node.getDEPTH()+1);
                    childNodes.add(newNode);
                }
                else{
                    System.out.println("Cannot do: "+m.direction+"\non"+Node.result(node));
                }
            }
        }
        return childNodes;
    }
    
}
