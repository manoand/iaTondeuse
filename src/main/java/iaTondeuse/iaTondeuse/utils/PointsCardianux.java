package iaTondeuse.iaTondeuse.utils;

public enum PointsCardianux {
	N("E","O"),
	E("S","N"),
	S("O","E"),
	O("N","S");
	
	private String gauche;
	private String droite;

	private PointsCardianux(String droite,String gauche) {
		this.droite = droite;
		this.gauche = gauche;
	}

	public String getGauche() {
		return gauche;
	}

	public String getDroite() {
		return droite;
	}

}
