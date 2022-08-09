import aima.core.environment.map2d.SimplifiedRoadMapOfPartOfRomania;
import aima.core.environment.support.ProblemFactory;
import aima.core.environment.vacuum.VELocalState;
import aima.core.environment.vacuum.VacuumEnvironment;
import aima.core.search.api.Problem;
import aima.core.search.basic.uninformedsearch.UniformCostSearch;

import java.util.List;

public class Implementation {
    static UniformCostSearch searchInstance = new UniformCostSearch();

    public static void main(String[] args) {
        romaniaPathProblem();

        vacuumEnvironmentProblem();
    }

    public static void romaniaPathProblem() {
        Problem romaniaProblem = ProblemFactory.getSimplifiedRoadMapOfPartOfRomaniaProblem(
                SimplifiedRoadMapOfPartOfRomania.ARAD, SimplifiedRoadMapOfPartOfRomania.BUCHAREST);

        List resultPath = searchInstance.apply(romaniaProblem);

        System.out.println("Romania Problem:");
        System.out.printf("Arad");
        for (int i = 0; i < resultPath.size(); i++) {
            System.out.printf(" -> " + resultPath.get(i));
        }
        System.out.println("\n------------------------------------");
    }

    public static void vacuumEnvironmentProblem() {
        Problem vacuumProblem = ProblemFactory.getSimpleVacuumWorldProblem("B",
                new VELocalState("A", VacuumEnvironment.Status.Dirty),
                new VELocalState("B", VacuumEnvironment.Status.Clean));

        List resultPath = searchInstance.apply(vacuumProblem);

        System.out.println("Vacuum Problem:");
        System.out.printf("B (Initial State)");
        for (int i = 0; i < resultPath.size(); i++) {
            System.out.printf(" -> " + resultPath.get(i));
        }
        System.out.println("\n------------------------------------");
    }
}
