package rnd.expression.parser;

import static rnd.expression.operator.Operator.OperatorAssociativity.Left;
import static rnd.expression.operator.Operator.OperatorAssociativity.Right;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import rnd.expression.Expression;
import rnd.expression.operator.ArithmeticOperators;
import rnd.expression.operator.EqualityOperators;
import rnd.expression.operator.LogicalOperators;
import rnd.expression.operator.Operator;
import rnd.expression.operator.OperatorsRegistory;
import rnd.expression.operator.RelationalOperators;
import rnd.expression.parser.tree.node.DNode;
import rnd.expression.parser.tree.node.ONode;
import rnd.expression.parser.tree.node.XNode;

public class XP {

	private static final OperatorsRegistory OPREG = new OperatorsRegistory();

	static {

		// 1
		OPREG.registerOperator2(LogicalOperators.OR);
		// 2
		OPREG.registerOperator2(LogicalOperators.AND);

		// 3
		OPREG.registerOperator2(EqualityOperators.EQUAL_TO);
		OPREG.registerOperator2(EqualityOperators.NOT_EQUAL_TO);

		// 4
		OPREG.registerOperator(RelationalOperators.GT);
		OPREG.registerOperator(RelationalOperators.LT);
		OPREG.registerOperator2(RelationalOperators.GTE);
		OPREG.registerOperator2(RelationalOperators.LTE);

		// 5
		OPREG.registerOperator(ArithmeticOperators.PLUS);
		OPREG.registerOperator(ArithmeticOperators.MINUS);

		// 6
		OPREG.registerOperator(ArithmeticOperators.MULTIPLY);
		OPREG.registerOperator(ArithmeticOperators.DIVIDE);
		OPREG.registerOperator(ArithmeticOperators.MODULO);

		// 7
		OPREG.registerOperator(LogicalOperators.NOT);

	}

	public static Expression parse(String exp) {
		Queue rpnNodeQueue = applyShuntingYardAlgo(exp);
		Expression expresion = evaluateRPNExp(rpnNodeQueue);
		return expresion;
	}

	public static Queue applyShuntingYardAlgo(String exp) {

		Queue<XNode> nodeQueue = new LinkedList<XNode>();

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
							nodeQueue.offer(new ONode(op2));
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
				DNode node = new DNode(identifier);
				nodeQueue.offer(node);
			}
			// Numbers
			else if (Character.isDigit(ch)) {
				Number number = consumeNumber(xInfo);
				nodeQueue.offer(new DNode(number));
			}
			// Literals
			else if (ch == '\'') {
				String literal = consumeLiteral(xInfo);
				nodeQueue.offer(new DNode(literal));
			}
		}

		while (!stack.isEmpty()) {
			nodeQueue.offer(stack.pop());
		}

		System.out.println("Stack :" + stack);
		System.out.println("Queue :" + nodeQueue);
		return nodeQueue;
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

	private static Expression evaluateRPNExp(Queue<XNode> rpnNodeQueue) {

		while (!rpnNodeQueue.isEmpty()) {
			XNode node = rpnNodeQueue.poll();
			
			if (node instanceof DNode) {
//				DNode dNode = (DNode) node;

			} else {
				ONode oNode = (ONode) node;
				Operator op = oNode.getOperator();

				if (op instanceof ArithmeticOperators) {
//					BinaryExpression be = new BinaryExpression();

				} else if (op instanceof EqualityOperators) {
//					BinaryExpression be = new BinaryExpression();

				} else if (op instanceof LogicalOperators) {
					if (op == LogicalOperators.NOT) {
//						UnaryNegationExpression une = new UnaryNegationExpression();
					} else {
//						BinaryExpression be = new BinaryExpression();
					}
				} else if (op instanceof RelationalOperators) {
//					BinaryExpression be = new BinaryExpression();
				}

			}

		}

		return null;
	}

}
