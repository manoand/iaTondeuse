package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;

import org.junit.Test;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.utils.FileTestUtils;
import junit.framework.TestCase;

public class FilteTestUtilsTest extends TestCase {
	
	private FileTestUtils fileTestUtils;
	
    @Override
    protected void setUp() throws Exception
    {
    	this.fileTestUtils = new FileTestUtils();
    }
    
    @Test
    public void test_lecture_fichier() {
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3,"E"), "AADAADADDA");
        mapTondeuse.put(new Tondeuse(1, 4, "S"), "AAAAAA");
        InitParam initParam = fileTestUtils.readFileTest();
        assertEquals(new Coordonnees(5,5), initParam.getCoordMax()); 
        assertEquals(mapTondeuse,initParam.getMapTondeuse());
    }

}
