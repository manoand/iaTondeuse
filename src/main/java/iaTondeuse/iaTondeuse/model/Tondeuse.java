package iaTondeuse.iaTondeuse.model;

public class Tondeuse {
	private Coordonnees coordonnees;
	private String direction;
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getDirenction() {
		return direction;
	}
	public void setDirection(String direnction) {
		this.direction = direnction;
	}
	public Tondeuse(Integer x, Integer y ,String direction) {
		super();
		this.direction = direction;
		this.coordonnees =new Coordonnees(x, y);
	}
	@Override
	public String toString() {
		return coordonnees.getX()+" "+coordonnees.getY()+" "+this.direction;
	}
	
}
