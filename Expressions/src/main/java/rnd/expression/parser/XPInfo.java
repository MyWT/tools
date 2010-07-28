package rnd.expression.parser;

public class XPInfo {

	private char[] exp;

	private int loc;

	private char ch;

	private char ch2;

	public XPInfo(String exp) {
		this.exp = exp.toCharArray();
	}

	public boolean next() {

		if (!hasNext()) {
			return false;
		}

		ch = exp[loc];
		ch2 = (char) -1;

		loc++;

		if (hasNext()) {
			ch2 = exp[loc];
		}
		
		return true;
	}

	public char currChar() {
		return ch;
	}

	public char nextChar() {
		return ch2;
	}

	private boolean hasNext() {
		return loc < exp.length;
	}

	int getLocation() {
		return loc;
	}

}
