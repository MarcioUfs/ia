import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;
import aima.core.search.api.Node;
import aima.core.search.api.Problem;
import aima.core.search.basic.uninformed.DepthLimitedTreeSearch;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;
import aima.core.search.basic.uninformedsearch.IterativeDeepeningSearch;
import aima.core.search.basic.uninformedsearch.UniformCostSearch;

import java.util.List;

public class Main1 {
    private static BreadthFirstSearch bfs = new BreadthFirstSearch();
    private static UniformCostSearch uniformcost = new UniformCostSearch();
    private static final int limite = 5;
    private static DepthLimitedTreeSearch dlts = new DepthLimitedTreeSearch(limite);
    private static IterativeDeepeningSearch ids = new IterativeDeepeningSearch();

    public static void main(String[] args) {

        Problem problema = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);

        System.out.println("Algoritmo bfs");
        Node resposta_bfs = bfs.search(problema);
        imprimir(resposta_bfs);

        System.out.println("Algoritmo uniform cost search");
        Node resposta_uc = uniformcost.search(problema);
        imprimir(resposta_uc);

        System.out.println("Algoritmo depth limited tree search");
        List resposta_dlts = dlts.depthLimitedSearch(problema,limite);
        imprimir(resposta_dlts,limite);

        System.out.println("Algoritmo iterative deepening search");
        Node resposta_ids = ids.search(problema);
        imprimir(resposta_ids);
    }

    public static void imprimir(Node resposta){
        System.out.println("estado final: " + resposta.state().toString() + " e custo: " + resposta.pathCost());
        System.out.println();
    }
    public static void imprimir(List resposta, int limite){
        System.out.println("caminho encontrado com limite " + limite + ": " + resposta.toString());
        System.out.println();
    }

}