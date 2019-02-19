package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import iaTondeuse.iaTondeuse.model.Chainon;
import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.ListDoublementChainee;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.service.TondeuseService;


public class App 
{
    public static void main( String[] args )
    {        
        Integer xMax = 5;
        Integer yMax = 5;
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3, "E"), "AADAADADDA");
        mapTondeuse.put(new Tondeuse(1, 3, "S"), "A");
        
        TondeuseService tondeuseService = new TondeuseService(); 
        System.out.println(tondeuseService.lancementTondeuse(mapTondeuse, xMax, yMax));

    }
    

    
}
