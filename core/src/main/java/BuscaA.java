import aima.core.search.api.Node;
import aima.core.search.basic.informed.AStarSearch;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;
import aima.core.search.basic.uninformedsearch.GenericSearch;
import aima.core.search.basic.uninformedsearch.IterativeDeepeningSearch;
import aima.core.search.basic.uninformedsearch.UniformCostSearch;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BuscaA {
    static GenericSearch dfs = new GenericSearch() {
        @Override
        public Queue<Node> addToFrontier(Node child, Queue frontier) {
            ((LinkedList<Node>) frontier).addFirst(child);
            return frontier;
        }

        @Override
        public boolean canImprove(HashMap reached, Node solution) {
            return solution == null;
        }
    };
    static BreadthFirstSearch bfs = new BreadthFirstSearch();
    static IterativeDeepeningSearch ids = new IterativeDeepeningSearch();
    static UniformCostSearch ucs = new UniformCostSearch();
    public static void main(String[] args) {

    }
}
