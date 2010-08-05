package rnd.expression.parser;

import org.junit.BeforeClass;
import org.junit.Test;

import rnd.expression.Expression;
import rnd.expression.PropertyExpression;
import rnd.expression.PropertyExpression.PropertyExpressionBuilder;

public class TestXP {

	String exp = "!a || !b || !c || !d";

	@BeforeClass
	public static void initBuilder() {
		PropertyExpression.setPropertyExpressionBuilder(new PropertyExpressionBuilder() {
			@Override
			public PropertyExpression buildPropertyExpression(String prpName) {
				return new PropertyExpression(prpName) {
				};
			}
		});
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
