package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;

import org.junit.Test;

import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.service.TondeuseService;
import junit.framework.TestCase;


/**
 * Unit test for simple App.
 */

public class TondeuseServiceTest extends TestCase
{

	private TondeuseService tondeuseService;
    @Override
    protected void setUp() throws Exception
    {
    	this.tondeuseService = new TondeuseService();
    }
	@Test
	public void test_lancement_2_Tondeuses() {
        Integer xMax = 5;
        Integer yMax = 5;
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3, "E"), "AADAADADDA");
        assertEquals("1 3 N \n" + 
        		"5 1 E \n",this.tondeuseService.lancementTondeuse(mapTondeuse, xMax, yMax));
	}
	@Test
	public void test_lancement_Tondeuse_sur_case_occupee() {
        Integer xMax = 5;
        Integer yMax = 5;
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(1, 4, "S"), "A");
        assertEquals("1 3 N \n" + 
        		"1 4 S \n",this.tondeuseService.lancementTondeuse(mapTondeuse, xMax, yMax));
	}
}
