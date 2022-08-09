package myWork;

import aima.core.environment.map2d.GoAction;
import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;
import aima.core.search.api.Problem;
import aima.core.search.api.*;
import aima.core.search.basic.uninformedsearch.BreadthFirstSearch;

import java.util.Arrays;
import java.util.List;

class Teste {
    static BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    public static void main(String[] args) {
        System.out.println("testes");
        BFS();
    }
    public static void BFS(){
        Problem problem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);
        Node result = breadthFirstSearch.search(problem);

        System.out.println(breadthFirstSearch.apply(problem));
        System.out.println(result);
    }
}
