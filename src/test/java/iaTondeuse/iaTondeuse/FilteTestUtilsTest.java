package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;

import org.junit.Test;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.service.FileService;
import junit.framework.TestCase;

public class FilteTestUtilsTest extends TestCase {
	
	private FileService fileTestUtils;
	
    @Override
    protected void setUp() throws Exception
    {
    	this.fileTestUtils = new FileService();
    }
    
    @Test
    public void test_lecture_fichier() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3,"E"), "AADAADADDA");
        mapTondeuse.put(new Tondeuse(1, 4, "S"), "AAAAAA");
        InitParam initParam = fileTestUtils.readFile();
        assertEquals(new Coordonnees(5,5), initParam.getCoordMax()); 
        assertEquals(mapTondeuse,initParam.getMapTondeuse());
    }

}
