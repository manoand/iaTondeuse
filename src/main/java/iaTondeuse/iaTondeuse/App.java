package iaTondeuse.iaTondeuse;

import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.service.FileService;
import iaTondeuse.iaTondeuse.service.TondeuseService;


public class App 
{
    public static void main( String[] args )
    {        
    	FileService fileTestUtils = new FileService();
        InitParam initParam = fileTestUtils.readFile();
        TondeuseService tondeuseService = new TondeuseService(); 
        System.out.println(tondeuseService.lancementTondeuse(initParam));
    }
    

    
}
