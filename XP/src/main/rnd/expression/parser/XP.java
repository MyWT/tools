package rnd.expression.parser;

import static rnd.expression.parser.operator.Operator.OperatorAssociativity.Left;
import static rnd.expression.parser.operator.Operator.OperatorAssociativity.Right;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import rnd.expression.BinaryExpression;
import rnd.expression.BinaryOperation;
import rnd.expression.Expression;
import rnd.expression.LiteralExpression;
import rnd.expression.PropertyExpression;
import rnd.expression.UnaryNegationExpression;
import rnd.expression.parser.operator.ArithmeticOperators;
import rnd.expression.parser.operator.EqualityOperators;
import rnd.expression.parser.operator.LogicalOperators;
import rnd.expression.parser.operator.Operator;
import rnd.expression.parser.operator.OperatorsRegistory;
import rnd.expression.parser.operator.RelationalOperators;
import rnd.expression.parser.tree.node.DNode;
import rnd.expression.parser.tree.node.ONode;
import rnd.expression.parser.tree.node.XNode;
import rnd.expression.parser.tree.node.DNode.DNodeType;

public class XP {

	private static final OperatorsRegistory OPREG = new OperatorsRegistory();

	static {

		// 1
		OPREG.registerOperator2(LogicalOperators.OR, BinaryOperation.OR);

		// 2
		OPREG.registerOperator2(LogicalOperators.AND, BinaryOperation.AND);

		// 3
		OPREG.registerOperator2(EqualityOperators.EQUAL_TO, BinaryOperation.EQUALS);
		OPREG.registerOperator2(EqualityOperators.NOT_EQUAL_TO, BinaryOperation.NOT_EQUALS);

		// 4
		OPREG.registerOperator(RelationalOperators.LT, BinaryOperation.LT);
		OPREG.registerOperator(RelationalOperators.GT, BinaryOperation.GT);
		OPREG.registerOperator2(RelationalOperators.LTE, BinaryOperation.LTE);
		OPREG.registerOperator2(RelationalOperators.GTE, BinaryOperation.GTE);

		// 5
		OPREG.registerOperator(ArithmeticOperators.PLUS, BinaryOperation.ADD);
		OPREG.registerOperator(ArithmeticOperators.MINUS, BinaryOperation.SUBTRACT);

		// 6
		OPREG.registerOperator(ArithmeticOperators.MULTIPLY, BinaryOperation.MULTIPLY);
		OPREG.registerOperator(ArithmeticOperators.DIVIDE, BinaryOperation.DIVIDE);
		OPREG.registerOperator(ArithmeticOperators.MODULO, BinaryOperation.MODULO);

		// 7
		OPREG.registerOperator(LogicalOperators.NOT);

	}

	public static Expression parse(String exp) {
		Queue rpnNodeQueue = applyShuntingYard(exp);
		Expression expresion = evaluateRPNExp(rpnNodeQueue);
		return expresion;
	}

	public static Queue applyShuntingYard(String exp) {

		Queue<XNode> rpnQueue = new LinkedList<XNode>();

		Stack<XNode> stack = new Stack<XNode>();

		XPInfo xInfo = new XPInfo(exp);

		while (xInfo.next()) {

			char ch = xInfo.currChar();
			char ch2 = xInfo.nextChar();

			if (Character.isWhitespace(ch)) {
				continue;
			}

			// Operators
			Operator op1 = OPREG.getOperator(ch);
			Operator op2 = OPREG.getOperator2(ch, ch2);

			if (op2 != null) {
				op1 = op2;
				xInfo.next();
			}

			if (op1 != null) {

				while (!stack.isEmpty()) {

					XNode node = stack.pop();

					if (node instanceof ONode) {
						op2 = ((ONode) node).getOperator();

						if ((op1.getAssociativity().equals(Left) && op1.getPrecedence() <= op2.getPrecedence()) //
								|| op1.getAssociativity().equals(Right) && op1.getPrecedence() < op2.getPrecedence()) {
							rpnQueue.offer(new ONode(op2));
						} else {
							stack.push(node);
							break;
						}
					}
				}
				stack.push(new ONode(op1));
			}

			// Identifiers
			else if (Character.isJavaIdentifierStart(ch)) {
				String identifier = consumeIdentifier(xInfo);
				DNode node = new DNode(identifier, DNodeType.VARIABLE);
				rpnQueue.offer(node);
			}

			// Numbers
			else if (Character.isDigit(ch)) {
				Number number = consumeNumber(xInfo);
				rpnQueue.offer(new DNode(number, DNodeType.LITERAL));
			}

			// Literals
			else if (ch == '\'') {
				String literal = consumeLiteral(xInfo);
				rpnQueue.offer(new DNode(literal, DNodeType.LITERAL));
			}
		}

		while (!stack.isEmpty()) {
			rpnQueue.offer(stack.pop());
		}

		// System.out.println("Stack :" + stack);
		// System.out.println("Queue :" + rpnQueue);
		
		return rpnQueue;
	}

	private static String consumeLiteral(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder("'");
		while (xInfo.next() && xInfo.currChar() != '\'') {
			sb.append(xInfo.currChar());
		}
		return sb.toString();
	}

	private static Number consumeNumber(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder();
		while (xInfo.next() && (Character.isDigit(xInfo.currChar()) || xInfo.currChar() == '.')) {
			sb.append(xInfo.currChar());
		}
		return new BigDecimal(sb.toString());
	}

	private static String consumeIdentifier(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder().append(xInfo.currChar());
		while (xInfo.next() && Character.isJavaIdentifierPart(xInfo.currChar())) {
			sb.append(xInfo.currChar());
		}
		return sb.toString();
	}

	private static Expression evaluateRPNExp(Queue<XNode> rpnQueue) {

		Stack<Expression> expStack = new Stack<Expression>();

		while (!rpnQueue.isEmpty()) {

			XNode node = rpnQueue.poll();

			if (node instanceof DNode) {

				DNode dNode = (DNode) node;

				Expression de = null;
				switch (dNode.getNodeType()) {
				case LITERAL:
					de = new LiteralExpression(dNode.getData());
					break;
				case VARIABLE:
					de = PropertyExpression.getPropertyExpression(dNode.getData());
					break;
				}
				expStack.push(de);
			} else {

				ONode oNode = (ONode) node;
				Operator op = oNode.getOperator();

				if (op == LogicalOperators.NOT) {
					UnaryNegationExpression une = new UnaryNegationExpression(expStack.pop());
					expStack.push(une);
				} else {
					BinaryExpression be = new BinaryExpression(expStack.pop(), expStack.pop(), OPREG.getBinaryOperation(op));
					expStack.push(be);
				}
			}
		}

		return expStack.peek();
	}

	// public static void printExpresion(Expression exp) {
	// if (exp instanceof BinaryExpression) {
	// BinaryExpression be = (BinaryExpression) exp;
	// printExpresion(be.getSecondExpression());
	// System.out.print(" " + be.getOperation() + " ");
	// printExpresion(be.getFirstExpression());
	// } else {
	// System.out.print(exp);
	// }
	// }

}
