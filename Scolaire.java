package com.company;

public interface Scolaire {
	public boolean petit();
	public boolean moyen();
	public boolean grand();
	/*Comment aurait-on pu faire si on n’avait pas utilisé d’interface ?
	 * En utilisant un héritage supplétaire, créant une classe abstraite de "grands"
	 */
}
