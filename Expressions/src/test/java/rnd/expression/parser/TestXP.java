package rnd.expression.parser;

import org.junit.Test;

public class TestXP {

	@Test
	public void testShuntingYard() {
		String exp = "!isLetter || !isStatus || !isLable || !isReason";
		// isLetter ! isStatus ! || isLable ! || isReason ! ||		
		XP.applyShuntingYardAlgo(exp);
	}
}
