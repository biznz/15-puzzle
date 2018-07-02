
package pkg15.puzzle;

import java.util.HashSet;
import pkg15.puzzle.heuristic.Heuristic;

/**
 *
 * @author biznz
 */
public class Settings {
    
    private int maxDepth;
    private int currentDepth;
    private int currentCost;
    private int visitedNodes;
    private boolean check_in_path;
    private HashSet<Heuristic> heuristics;
    
}
