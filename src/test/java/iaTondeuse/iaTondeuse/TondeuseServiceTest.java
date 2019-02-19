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
	public void test_lancement_3_Tondeuses() {
        Integer xMax = 5;
        Integer yMax = 5;
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3, "E"), "AADAADADDA");
        mapTondeuse.put(new Tondeuse(1, 3, "S"), "A");
        this.tondeuseService.lancementTondeuse(mapTondeuse, xMax, yMax);
	}
}
