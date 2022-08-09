package myWork;

import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;
import aima.core.search.api.Node;
import aima.core.search.api.Problem;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;
import aima.core.search.basic.uninformedsearch.UniformCostSearch;
import aima.core.search.basic.uninformedsearch.DepthLimitedSearch;
import aima.core.search.basic.uninformedsearch.IterativeDeepeningSearch;


class GVSS {
    static BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
    static UniformCostSearch uniformCostSearch = new UniformCostSearch();

    static DepthLimitedSearch depthLimitedSearch = new DepthLimitedSearch();

    static IterativeDeepeningSearch iterativeDeepeningSearch = new IterativeDeepeningSearch();

    public static void main(String[] args) {
        System.out.println("Teste BFS");
        BFS();
        System.out.println("Teste Coast Search");
        coastSearch();
        System.out.println("Teste DFS Limited");
        DFS();
        System.out.println("Teste IDS Limited");
        IDS();
    }

    public static void BFS(){
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);
        Node result = breadthFirstSearch.search(problem);
        System.out.println(breadthFirstSearch.apply(problem));
        System.out.println(result);
    }

    public static void coastSearch(){
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);
        System.out.println(uniformCostSearch.apply(problem));
    }

    public static void DFS(){
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);
        System.out.println(depthLimitedSearch.search(problem, 6));
    }

    public static void IDS(){
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);
        System.out.println(iterativeDeepeningSearch.search(problem));
    }
}
