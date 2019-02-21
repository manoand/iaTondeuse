package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.service.TondeuseService;
import iaTondeuse.iaTondeuse.utils.FileTestUtils;


public class App 
{
    public static void main( String[] args )
    {        
    	FileTestUtils fileTestUtils = new FileTestUtils();
        InitParam initParam = fileTestUtils.readFileTest();
        TondeuseService tondeuseService = new TondeuseService(); 
        System.out.println(tondeuseService.lancementTondeuse(initParam));
    }
    

    
}
