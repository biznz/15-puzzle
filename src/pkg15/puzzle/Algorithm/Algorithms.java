
package pkg15.puzzle.Algorithm;

import static pkg15.puzzle.Game.*;
import java.util.AbstractCollection;
import java.util.Set;
import java.util.Stack;
import pkg15.puzzle.game.Problem;
import pkg15.puzzle.game.Node;

/**
 *
 * @author biznz
 */
public abstract class Algorithms {
    
    
    protected static String GENERAL_SEARCH(Problem initialProblem,Problem finalProblem, AbstractCollection<Node> QUEUEING_FN){
        
        if(!SOLVABLE(initialProblem,finalProblem)){return "It is impossible to reach a solution" ;}
        AbstractCollection<Node> nodes = MAKE_QUEUE(QUEUEING_FN,MAKE_NODE(INITIAL_STATE(initialProblem)));
        while(!EMPTY(nodes)){
            Node node = REMOVE_FRONT(nodes);
            if (STATE(node).equals(GOAL_TEST(finalProblem))){
                Path = new Stack<Node>();
                Path.build(node);
                System.out.println("max Nodes:"+QUEUEING_FN.maxSize);
                System.out.println("visited "+visitedNodes+" nodes");
                System.out.println("Solution found @ depth:"+node.DEPTH);
                return Path.pathPrint();
            }
            Set<Node> new_nodes = EXPAND(node,OPERATORS());
            nodes = QUEUEING_FN.add(nodes,new_nodes);
        }
        System.out.println("max Nodes:"+QUEUEING_FN.maxSize);
        System.out.println("visited "+visitedNodes+" nodes");
        return "solution not found";
    }
}
