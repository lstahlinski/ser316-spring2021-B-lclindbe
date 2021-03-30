import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

//@RunWith(Parameterized.class)
public class calculateDamageTest {
    /*
    private Class<BattleScenario> classUnderTest;

    @SuppressWarnings("unchecked")
    public calculateDamageTest(Object classUnderTest) {
        this.classUnderTest = (Class<BattleScenario>) classUnderTest;
    }

    @Parameters
    public static Collection<Object[]> courseGradesUnderTest() {
        Object[][] classes = {
                {BattleScenario1.class},
                {BattleScenario2.class},
                {BattleScenario3.class},
                {BattleScenario4.class},
                {BattleScenario5.class}

        };
        return Arrays.asList(classes);
    }

    private BattleScenario createBattleScenario(Mascotmon a, Mascotmon d) throws Exception {
        Constructor<BattleScenario> constructor = classUnderTest.getConstructor(Mascotmon.class, Mascotmon.class);
        System.out.println(constructor);
        return constructor.newInstance(a, d);
    }
    */

    @Before
    public void setUp() throws Exception {
        
    }
    
    @After
    public void tearDown() throws Exception {
    }
    
    /**
     * Test Scenario # 1 - Initial pAttackDamage is 0
     * @throws Exception 
     */
    
    @Test
    public void initialAttackDamange () throws Exception{
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("    initialAttackDamange");
        fight1.setEnvironment(Environment.Weather.sunny);

        Attack attack = new Attack(0, "None");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        

        assertEquals(damage, 0, 0.2);       
    }

    /**
     * Test Scenario # 2 - Negative Attack equals 1
     * @throws Exception 
     */
    
    @Test
    public void negtiveAttack() throws Exception {
        Mascotmon attacker2 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender2 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = new BattleScenario(attacker2, defender2);
        System.out.println("    negtiveAttack");
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(20, "Normal");
        double damage = fight1.calculateDamage(attack, attacker2, defender2);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 1, 0.2);
    }

    
    /**
     * Test Scenario # 3 - Positive Attack
     * @throws Exception 
     */
    
    @Test
    public void positiveAttack() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight3 = new BattleScenario(attacker1, defender1);
        System.out.println("    positiveAttack");
        fight3.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Normal");

        double damage = fight3.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 50, 0.2);
    }


    /**
     * Test Scenario # 4 - Sunny Environment with Fire Type
     * @throws Exception 
     */
    
    @Test
    public void sunnywithFire() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("    sunnywithFire");
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(70, "Fire");
        
        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 65, 0.2);
    }

    
     /**
     * Test Scenario # 5 - Sunny with Water
     * @throws Exception 
     */
    
    @Test
    public void sunnywithWater() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("    sunnywithWater");
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(60, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 14, 0.2);
    }

    
    /**
     * Test Scenario # 6 - Drought with Normal
     * @throws Exception 
     */
    
    @Test
    public void droughtwithNormal() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("    droughtwithNormal");
        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(70, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 54, 0.2);
    }

    /**
     * Test Scenario # 7 - Drought with Ground
     * @throws Exception 
     */
    
    @Test
    public void droughtwithGround() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("   droughtwithGround");
        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 40, 0.2);
    }
    

    /**
     * Test Scenario # 8 - Rainy with Fire
     * @throws Exception 
     */
    
    @Test
    public void rainywithFire() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.BULLY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.SPARKY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1); 
        System.out.println("   rainywithFire");
        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(80, "Normal");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 66, 0.2);
    }


    /**
     * Test Scenario # 9 - Rainy with Water
     * @throws Exception 
     */
    
    @Test
    public void rainywithWater() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.ALBERT);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.BULLY);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("   rainywithWater");
        fight1.setEnvironment(Environment.Weather.rainy);
        Attack attack = new Attack(80, "Water");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 80, 0.2);
    }  



    /**
     * Test Scenario # 10a - Ground vs Water
     * @throws Exception 
     */
    
    @Test
    public void groundVSWater() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("    groundVsWater");
        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Ground");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 120, 0.2);
    }

    /**
     * Test Scenario # 10b - Fire vs Ground
     * @throws Exception 
     */
    
    @Test
    public void firevsGround() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.RALPHIE);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);
        System.out.println("    firevsGround");
        fight1.setEnvironment(Environment.Weather.sunny);
        Attack attack = new Attack(80, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 101, 0.2);
    }

    /**
     * Test Scenario # 10c - Fire vs Water
     * @throws Exception 
     */
    
    @Test
    public void firevsWater() throws Exception {
        Mascotmon attacker1 = new Mascotmon(Mascotmon.Name.SPARKY);
        Mascotmon defender1 = new Mascotmon(Mascotmon.Name.ALBERT);
        
        BattleScenario fight1 = new BattleScenario(attacker1, defender1);; 
        System.out.println("    firevsWater");
        fight1.setEnvironment(Environment.Weather.drought);
        Attack attack = new Attack(80, "Fire");

        double damage = fight1.calculateDamage(attack, attacker1, defender1);
        System.out.println("         Damage dealt: " + damage);
        assertEquals(damage, 22, 0.2);
    }
}
