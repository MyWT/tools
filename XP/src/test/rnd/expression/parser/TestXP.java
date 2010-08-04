package rnd.expression.parser;

import org.junit.Test;

import rnd.expression.Expression;

public class TestXP {

	String exp = "!a || !b || !c || !d";

//	@Test
	public void testShuntingYard() {
		XP.applyShuntingYard(exp);
	}

	@Test
	public void testParse() {
		System.out.println(exp);
		Expression xpsn = XP.parse(exp);
		XP.printExpresion(xpsn);
		assert xpsn != null;
	}

}
