package iaTondeuse.iaTondeuse.service;

import java.util.LinkedHashMap;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.utils.FileTestUtils;
import junit.framework.TestCase;

public class TondeuseServiceTestUni extends TestCase {
	

	private TondeuseService tondeuseService;
	
    @Override
    protected void setUp() throws Exception
    {
    	this.tondeuseService  = new TondeuseService();
    }
    
    @Test
    public void test_mapContains_true() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
    	assertTrue(this.tondeuseService.mapContainsCoordonnes(mapTondeuse, new Coordonnees(1,2)));
    }
    
    @Test
    public void test_mapContains_false() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 8, "N"), "GAGAGGAA");
    	assertFalse(this.tondeuseService.mapContainsCoordonnes(mapTondeuse, new Coordonnees(1,2)));
    }
    
    @Test
    public void test_deplacement_valide() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
    	assertEquals("E",this.tondeuseService.deplacementTondeuse(mapTondeuse, new Tondeuse(1, 2, "N"), "E", new Coordonnees(1, 2), new Coordonnees(6, 6)));
    }
    
    @Test
    public void test_deplacement_non_valide() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
    	assertEquals("N",this.tondeuseService.deplacementTondeuse(mapTondeuse, new Tondeuse(0, 2, "N"), "O", new Coordonnees(1, 2), new Coordonnees(6, 6)));
    }
}
