package iaTondeuse.iaTondeuse.service;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.InitParam;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.utils.PointsCardianux;

@Service
public class TondeuseService {

	public String lancementTondeuse( InitParam initParam) {
		StringBuilder res = new StringBuilder();
		LinkedHashMap<Tondeuse, String> mapTondeuse = initParam.getMapTondeuse();
		Coordonnees coordMax = initParam.getCoordMax();
		for (Tondeuse tondeuse : mapTondeuse.keySet()) {
			String nouvelleDirection = tondeuse.getDirenction();
        	for(char instruction : mapTondeuse.get(tondeuse).toCharArray()) {
        		Coordonnees coordTmp = new Coordonnees(tondeuse.getCoordonnees().getX(),tondeuse.getCoordonnees().getY());
        		switch (instruction) {
				case 'D':
					nouvelleDirection = PointsCardianux.valueOf(nouvelleDirection).getDroite().toString();
					break;
				case 'G':
					nouvelleDirection = PointsCardianux.valueOf(nouvelleDirection).getGauche().toString();
					break;
				case 'A' :
					nouvelleDirection = deplacementTondeuse(mapTondeuse, tondeuse, nouvelleDirection, coordTmp, coordMax);
					break;
				default:
					break;
				}
        	}
        	res.append(tondeuse.toString()+" \n");
        }
		return res.toString();
	}
	
    boolean mapContainsCoordonnes(LinkedHashMap<Tondeuse, String> mapTondeuse, Coordonnees coordonnees) {
    	return mapTondeuse.keySet().stream().map(Tondeuse :: getCoordonnees).collect(Collectors.toList()).contains(coordonnees);
    }
    
    String deplacementTondeuse(LinkedHashMap<Tondeuse, String> mapTondeuse,Tondeuse tondeuse,String nouvelleDirection,Coordonnees coordTmp,Coordonnees coordMax) {
    	String res = nouvelleDirection;
    	switch (nouvelleDirection) {
		case "N":
			coordTmp.setY(coordTmp.getY()+1);
			break;
		case "E":
			coordTmp.setX(coordTmp.getX()+1);
			break;
		case "S":
			coordTmp.setY(coordTmp.getY()-1);
			break;
		case "O":
			coordTmp.setX(coordTmp.getX()-1);
			break;	
		default:
			break;
		}
		if(coordTmp.getX() !=0 && coordTmp.getY() !=0 && coordTmp.getX()<=coordMax.getX() && coordTmp.getY() <= coordMax.getY() 
				&& !mapContainsCoordonnes(mapTondeuse, coordTmp)) {
			tondeuse.setCoordonnees(coordTmp);
			tondeuse.setDirection(nouvelleDirection);
		}else {
			res = tondeuse.getDirenction();
		}
		return res;
    }
}
