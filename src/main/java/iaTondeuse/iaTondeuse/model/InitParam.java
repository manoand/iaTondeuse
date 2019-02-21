package iaTondeuse.iaTondeuse.model;

import java.util.LinkedHashMap;

public class InitParam {
	private LinkedHashMap<Tondeuse, String> mapTondeuse;
	private Coordonnees coordMax;
	public InitParam(LinkedHashMap<Tondeuse, String> mapTondeuse, Coordonnees coordMax) {
		super();
		this.mapTondeuse = mapTondeuse;
		this.coordMax = coordMax;
	}
	public LinkedHashMap<Tondeuse, String> getMapTondeuse() {
		return mapTondeuse;
	}
	public Coordonnees getCoordMax() {
		return coordMax;
	}	
	
}
