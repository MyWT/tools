package rnd.expression.parser;

import org.junit.BeforeClass;
import org.junit.Test;

import rnd.expression.Expression;

public class TestXP {

	String exp = "!a || !b || !c || !d";

	@BeforeClass
	public static void initBuilder() {
		// ValueExpression.setPropertyExpressionBuilder(new
		// PropertyExpressionBuilder() {
		// @Override
		// public ValueExpression buildPropertyExpression(String prpName) {
		// return new ValueExpression(prpName) {
		// };
		// }
		// });
	}

	// @Test
	public void testShuntingYard() {
		XP.applyShuntingYard(exp);
	}

	@Test
	public void testParse() {

		System.out.println(exp);
		Expression xpsn = XP.parse(exp);
		System.out.println(xpsn);
		// XP.printExpresion(xpsn);
	}
}
