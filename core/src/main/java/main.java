import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;

import aima.core.search.api.Node;
import aima.core.search.api.Problem;

import aima.core.search.basic.uninformedsearch.UniformCostSearch;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;
import aima.core.search.basic.uninformedsearch.GenericSearch;
import aima.core.search.basic.uninformedsearch.IterativeDeepeningSearch;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;

public class main {

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

        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.DOBRETA);

        Node DFS = dfs.genericSearch(problem);
        List BFS = bfs.apply(problem);
        List IterDeepS = ids.apply(problem);
        List UnifCostS = ucs.apply(problem);

        System.out.println("DFS: " + DFS.state());
        System.out.println("BFS: " + path(BFS));
        System.out.println("IDS: " + path(IterDeepS));
        System.out.println("UCS: " + path(UnifCostS));

    }
    public static String path(List lista) {
        String action_seq = "Arad";
        for (int i = 0; i < lista.size(); i++)  { action_seq += " -> " + lista.get(i); }
        return action_seq;
    }
}