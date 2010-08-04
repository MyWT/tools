package rnd.expression;

public enum BinaryOperation {

	// Arithmatic Operation

	ADD("+"), SUBTRACT("-"), MULTIPLY("*"), DIVIDE("/"), MODULO("%"),

	// Equality Operation

	EQUALS("=="), NOT_EQUALS("!="),

	// Logical Operation

	AND("&&"), OR("||"),

	// Relational Operation

	LT("<"), GT(">"), LTE("<="), GTE(">=");

	private String opCode;

	BinaryOperation(String opCode) {
		this.opCode = opCode;
	}

	@Override
	public String toString() {
		return opCode;
	}
}
