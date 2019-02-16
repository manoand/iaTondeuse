package iaTondeuse.iaTondeuse.model;

public class ListDoublementChainee<E> {
	private Chainon<E> chainon;
	private Integer taille;
	public void setChainon(Chainon<E> chainon) {
		this.chainon = chainon;
	}
	public Integer getTaille() {
		return taille;
	}
	public void setTaille(Integer taille) {
		this.taille = taille;
	}
	public ListDoublementChainee(Chainon<E> chainon, Integer taille) {
		super();
		this.chainon = chainon;
		this.taille = taille;
	}
	public Chainon<E> getChainon(E element) {
		Chainon<E> res = this.chainon;
		Integer i = 0;
		while(res != null && i <this.taille) {
			if(res.getElement().equals(element)) {
				break;
			}else {
				res = res.getSuivant();
				i++;
			}
		}
		return res;
	}
	
}
