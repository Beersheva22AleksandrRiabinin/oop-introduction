package telran.util.test;

import java.util.function.Predicate;

public class SubctrPredicate implements Predicate<String> {
	String substr;

	@Override
	public boolean test(String t) {
		
		return t.contains(substr);
	}

	public SubctrPredicate(String substr) {
		this.substr = substr;
	}

}
