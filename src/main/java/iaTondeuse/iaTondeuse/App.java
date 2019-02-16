package iaTondeuse.iaTondeuse;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import iaTondeuse.iaTondeuse.model.Chainon;
import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.ListDoublementChainee;
import iaTondeuse.iaTondeuse.model.Tondeuse;


public class App 
{
    public static void main( String[] args )
    {
    	Chainon<String> nord = new Chainon<String>("N");
    	Chainon<String> sud = new Chainon<String>("S"); 
    	Chainon<String> est = new Chainon<String>("E");
    	Chainon<String> ouest = new Chainon<String>("O");
    	
    	nord.setPrecedent(ouest);
    	nord.setSuivant(est);
    	
    	est.setPrecedent(nord);
    	est.setSuivant(sud);
    	
    	sud.setPrecedent(est);
    	sud.setSuivant(ouest);
    	
    	ouest.setPrecedent(sud);
    	ouest.setSuivant(nord);
    	
        ListDoublementChainee<String> listDoublementChainee = new ListDoublementChainee<String>(nord, 4);
        
        Integer xMax = 5;
        Integer yMax = 5;
        LinkedHashMap<Tondeuse, String> mapTondeuse = new LinkedHashMap<Tondeuse, String>();
        mapTondeuse.put(new Tondeuse(1, 2, "N"), "GAGAGAGAA");
        mapTondeuse.put(new Tondeuse(3, 3, "E"), "AADAADADDA");
        mapTondeuse.put(new Tondeuse(1, 3, "S"), "A");
        
        for (Tondeuse tondeuse : mapTondeuse.keySet()) {
        	String nouvelleDirection = tondeuse.getDirenction();
        	for(char instruction : mapTondeuse.get(tondeuse).toCharArray()) {
        		Integer xTmp = tondeuse.getCoordonnees().getX();
        		Integer yTmp = tondeuse.getCoordonnees().getY();
        		switch (instruction) {
				case 'D':
					nouvelleDirection = listDoublementChainee.getChainon(nouvelleDirection).getSuivant().getElement();
					break;
				case 'G':
					nouvelleDirection = listDoublementChainee.getChainon(nouvelleDirection).getPrecedent().getElement();
					break;
				case 'A' :
					switch (nouvelleDirection) {
					case "N":
						yTmp+=1;
						break;
					case "E":
						xTmp+=1;
						break;
					case "S":
						yTmp-=1;
						break;
					case "O":
						xTmp-=1;
						break;	
					default:
						break;
					}
					Coordonnees coordonneesTmp = new Coordonnees(xTmp, yTmp);
					if(xTmp !=0 && yTmp !=0 && xTmp<=xMax && yTmp <= yMax && !mapContainsCoordonnes(mapTondeuse, coordonneesTmp)) {
						tondeuse.setCoordonnees(coordonneesTmp);
						tondeuse.setDirection(nouvelleDirection);
					}else {
						nouvelleDirection = tondeuse.getDirenction();
					}
					break;
				default:
					break;
				}
        	}
        	System.out.println(tondeuse.toString());
        }

    }
    
    static boolean mapContainsCoordonnes(LinkedHashMap<Tondeuse, String> mapTondeuse, Coordonnees coordonnees) {
    	return mapTondeuse.keySet().stream().map(Tondeuse :: getCoordonnees).collect(Collectors.toList()).contains(coordonnees);
    }
}
