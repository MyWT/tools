package rnd.expression.parser;

import org.junit.Test;

public class TestXP {

	@Test
	public void testShuntingYard() {
		String exp = "!a || !b || !c || !d";
		XP.applyShuntingYardAlgo(exp);
	}
}
