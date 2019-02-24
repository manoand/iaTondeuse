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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordonnees == null) ? 0 : coordonnees.hashCode());
		result = prime * result + ((direction == null) ? 0 : direction.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tondeuse other = (Tondeuse) obj;
		if (coordonnees == null) {
			if (other.coordonnees != null)
				return false;
		} else if (!coordonnees.equals(other.coordonnees))
			return false;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		return true;
	}
	
}
