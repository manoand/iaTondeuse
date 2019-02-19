package iaTondeuse.iaTondeuse.service;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import iaTondeuse.iaTondeuse.model.Coordonnees;
import iaTondeuse.iaTondeuse.model.ListDoublementChainee;
import iaTondeuse.iaTondeuse.model.Tondeuse;
import iaTondeuse.iaTondeuse.utils.PointsCardianux;

@Service
public class TondeuseService {

	public String lancementTondeuse(  LinkedHashMap<Tondeuse, String> mapTondeuse,Integer xMax,Integer yMax) {
		StringBuilder res = new StringBuilder();
		for (Tondeuse tondeuse : mapTondeuse.keySet()) {
			String nouvelleDirection = tondeuse.getDirenction();
        	for(char instruction : mapTondeuse.get(tondeuse).toCharArray()) {
        		Integer xTmp = tondeuse.getCoordonnees().getX();
        		Integer yTmp = tondeuse.getCoordonnees().getY();
        		switch (instruction) {
				case 'D':
					nouvelleDirection = PointsCardianux.valueOf(nouvelleDirection).getDroite().toString();
					break;
				case 'G':
					nouvelleDirection = PointsCardianux.valueOf(nouvelleDirection).getGauche().toString();
					break;
				case 'A' :
					nouvelleDirection = deplacementTondeuse(mapTondeuse, tondeuse, nouvelleDirection, xTmp, yTmp, xMax, yMax);
					break;
				default:
					break;
				}
        	}
        	res.append(tondeuse.toString()+" \n");
        }
		return res.toString();
	}
	
    private boolean mapContainsCoordonnes(LinkedHashMap<Tondeuse, String> mapTondeuse, Coordonnees coordonnees) {
    	return mapTondeuse.keySet().stream().map(Tondeuse :: getCoordonnees).collect(Collectors.toList()).contains(coordonnees);
    }
    
    private String deplacementTondeuse(LinkedHashMap<Tondeuse, String> mapTondeuse,Tondeuse tondeuse,String nouvelleDirection,Integer xTmp,Integer yTmp,Integer xMax,Integer yMax) {
    	String res = nouvelleDirection;
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
			res = tondeuse.getDirenction();
		}
		return res;
    }
}
