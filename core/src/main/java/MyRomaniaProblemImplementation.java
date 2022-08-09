import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;
import aima.core.search.api.Node;
import aima.core.search.api.Problem;
import aima.core.search.basic.uninformedsearch.DepthLimitedSearch;
import aima.core.search.basic.uninformedsearch.IterativeDeepeningSearch;
import aima.core.search.basic.uninformedsearch.UniformCostSearch;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyRomaniaProblemImplementation {
    private static BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    private static UniformCostSearch uniformCostSearch = new UniformCostSearch();
    private static DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch();
    private static IterativeDeepeningSearch iterativeDeepeningSearch = new IterativeDeepeningSearch();

    public static void main(String[] args) {
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(SimplifiedRoadMapOfPartOfRomania.HIRSOVA, SimplifiedRoadMapOfPartOfRomania.ZERIND);

        double bfs = breadthFirstSearchsResult(problem);
        double ufs = uniformCostSearchResult(problem);
        double dls = depthLimitedSearchResult(problem, Math.max(bfs, ufs));
        double ids = iterativeDeepeningSearchResult(problem);
    }

    public static double breadthFirstSearchsResult(Problem problem) {
        System.out.println("==========Breadth-First-Search:==========\n");

        Node result = breadthFirstSearch.search(problem);
        List<Node> path = new ArrayList<Node>();

        double cost = result.pathCost();
        System.out.println("Custo do caminho: " + cost + "\n");

        do {
            path.add(result);
            result = result.parent();
        } while (result != null);

        Collections.reverse(path);

        System.out.print("Caminho calculado: ");
        path.stream().forEach(city -> {System.out.print(city.state().toString() + " -> ");});

        System.out.println("\n");

        return cost;
    }

    public static double uniformCostSearchResult(Problem problem) {
        System.out.println("==========Uniform-Cost-Search:==========\n");

        Node result = uniformCostSearch.search(problem);
        List<Node> path = new ArrayList<Node>();

        double cost = result.pathCost();
        System.out.println("Custo do caminho: " + cost + "\n");

        do {
            path.add(result);
            result = result.parent();
        } while (result != null);

        Collections.reverse(path);

        System.out.print("Caminho calculado: ");
        path.stream().forEach(city -> System.out.print(city.state().toString() + " -> "));

        System.out.println("\n");

        return cost;
    }

    public static double depthLimitedSearchResult(Problem problem, double max) {
        System.out.println("==========Depth-Limited-Search:==========\n");

        Node result = depthLimitedSearch.search(problem, (int) max);
        List<Node> path = new ArrayList<Node>();

        double cost = result.pathCost();
        System.out.println("Custo do caminho: " + cost + "\n");

        do {
            path.add(result);
            result = result.parent();
        } while (result != null);

        Collections.reverse(path);

        System.out.print("Caminho calculado: ");
        path.stream().forEach(city -> System.out.print(city.state().toString() + " -> "));

        System.out.println("\n");

        return cost;
    }

    public static double iterativeDeepeningSearchResult(Problem problem) {
        System.out.println("==========Iterative-Deepening-Search:==========\n");

        Node result = iterativeDeepeningSearch.search(problem);
        List<Node> path = new ArrayList<Node>();

        double cost = result.pathCost();
        System.out.println("Custo do caminho: " + cost + "\n");

        do {
            path.add(result);
            result = result.parent();
        } while (result != null);

        Collections.reverse(path);

        System.out.print("Caminho calculado: ");
        path.stream().forEach(city -> System.out.print(city.state().toString() + " -> "));

        System.out.println("\n");

        return cost;
    }
}