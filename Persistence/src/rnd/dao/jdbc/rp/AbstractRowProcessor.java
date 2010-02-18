package rnd.dao.jdbc.rp;

public abstract class AbstractRowProcessor implements RowProcessor {

	protected int startIndex = 1, endIndex;

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
