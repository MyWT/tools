package rnd.expression.parser;

public class XPInfo {

	private char[] expCh;

	private int location;

	private char ch;

	private char ch1;

	public XPInfo(String exp) {
		this.expCh = exp.toCharArray();
	}

	public void next() {
		location++;
		ch = expCh[location];
		if (hasNext()) {
			ch1 = expCh[location + 1];
		} else {
			ch1 = (char) -1;
		}
	}

	public char currChar() {
		return ch;
	}

	public char nextChar() {
		return ch1;
	}

	public boolean hasNext() {
		return location < expCh.length - 1;
	}

	int getLocation() {
		return location;
	}

}
