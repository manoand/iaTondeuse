package iaTondeuse.iaTondeuse.utils;

public enum PointsCardianux {
	N("E","O"),
	E("N","S"),
	S("O","E"),
	O("S","N");
	
	private String gauche;
	private String droite;

	private PointsCardianux(String gauche,String droite) {
		this.gauche = gauche;
		this.droite = droite;
	}

	public String getGauche() {
		return gauche;
	}

	public String getDroite() {
		return droite;
	}

	static public PointsCardianux getPointCardinal(String lettre) {
		PointsCardianux res = null;
		switch (lettre) {
		case "N":
			res = N;
			break;
		case "S":
			res = S;
			break;
		case "E":
			res=E;
			break;
		case "O":
			res=O;
			break;
		default:
			break;
		}
		return res;
		
	}
}
