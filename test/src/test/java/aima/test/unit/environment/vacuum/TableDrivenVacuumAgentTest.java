package aima.test.unit.environment.vacuum;

import aima.core.environment.vacuum.TableDrivenVacuumAgent;
import aima.core.environment.vacuum.VEPercept;
import aima.core.environment.vacuum.VacuumEnvironment;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ciaran O'Reilly
 */
public class TableDrivenVacuumAgentTest {
    private TableDrivenVacuumAgent agent;

    @Before
    public void setUp() {
        agent = new TableDrivenVacuumAgent();
    }

    @Test
    public void testACleanAClean() {
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }


    @Test
    public void testACleanBClean() {
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testACleanBDirty() {
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Dirty))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        Assert.assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testADirtyBClean() {
        Assert.assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Dirty))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_LEFT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Clean))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        Assert.assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }

    @Test
    public void testADirtyBDirty() {
        Assert.assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Dirty))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_RIGHT,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
        Assert.assertEquals(
                VacuumEnvironment.ACTION_SUCK,
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_B, VacuumEnvironment.Status.Dirty))
        );
        // Table is only defined for max 3 percepts in a sequence, so will generate a null.
        Assert.assertNull(
                agent.perceive(new VEPercept(VacuumEnvironment.LOCATION_A, VacuumEnvironment.Status.Clean))
        );
    }
}
