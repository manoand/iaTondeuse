package iaTondeuse.iaTondeuse.model;

public class Chainon<E> {

	private E element;
	private Chainon<E> suivant;
	private Chainon<E> precedent;
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public Chainon<E> getSuivant() {
		return suivant;
	}
	public void setSuivant(Chainon<E> suivant) {
		this.suivant = suivant;
	}
	public Chainon<E> getPrecedent() {
		return precedent;
	}
	public void setPrecedent(Chainon<E> precedent) {
		this.precedent = precedent;
	}
	public Chainon(E element) {
		super();
		this.element = element;
	}
	
}
