package net.jason.spring;

public class TextEditor {
	private SpellChecker spellChecker;

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		System.out.println("Setter of SpellChecker.");
		this.spellChecker = spellChecker;
	}

	public void spellChecker() {
		
	}
}
