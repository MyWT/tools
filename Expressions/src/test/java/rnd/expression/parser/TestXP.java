package rnd.expression.parser;

import org.junit.Assert;
import org.junit.Test;

import rnd.expression.Expression;

public class TestXP {
	String exp = "!isLetter || !isStatus || !isLable || !isReason";

	// @Test
	public void testParse() {
		Expression expIns = XP.parse(exp);
		Assert.assertNotNull(expIns);
	}

	// @Test
	public void testChar() {
		boolean isDigit = Character.isDigit('1');
		Assert.assertTrue(isDigit);
	}
	
	@Test
	public void testShuntingYard() {
		XP.applyShuntingYardAlgo(exp);
	}

}
