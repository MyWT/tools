package rnd.expression.parser;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import rnd.expression.Expression;
import rnd.expression.operator.Operator;
import rnd.expression.parser.tree.node.DNode;
import rnd.expression.parser.tree.node.ONode;
import rnd.expression.parser.tree.node.XNode;

public class XP {

	public static Expression parse(String exp) {
		applyShuntingYardAlgo(exp);
		return null;
	}

	public static void applyShuntingYardAlgo(String exp) {

		Queue<XNode> queue = new LinkedList<XNode>();

		Stack<XNode> stack = new Stack<XNode>();

		XPInfo xInfo = new XPInfo(exp);

		for (; xInfo.hasNext(); xInfo.next()) {

			char ch = xInfo.currChar();
			char ch2 = xInfo.nextChar();

			if (Character.isWhitespace(ch)) {
				continue;
			} else if (ch == '*') {
				stack.push(new ONode(Operator.MULTIPLY));
			} else if (ch == '/') {
				stack.push(new ONode(Operator.DIVIDE));
			} else if (ch == '%') {
				stack.push(new ONode(Operator.MODULO));
			} else if (ch == '+') {
				stack.push(new ONode(Operator.PLUS));
			} else if (ch == '-') {
				stack.push(new ONode(Operator.MINUS));
			} else if (ch == '<') {
				if (ch2 == '=') {
					stack.push(new ONode(Operator.LTE));
					xInfo.next();
				} else {
					stack.push(new ONode(Operator.LT));
				}
			} else if (ch == '>') {
				if (ch2 == '=') {
					stack.push(new ONode(Operator.GTE));
					xInfo.next();
				} else {
					stack.push(new ONode(Operator.GT));
				}
			} else if (ch == '&') {
				if (ch2 == '&') {
					stack.push(new ONode(Operator.AND));
					xInfo.next();
				} else {
					throwInvalidTokenException(xInfo);
				}
			} else if (ch == '|') {
				if (ch2 == '|') {
					stack.push(new ONode(Operator.OR));
					xInfo.next();
				} else {
					throwInvalidTokenException(xInfo);
				}
			} else if (ch == '!') {
				stack.push(new ONode(Operator.NOT));
			} else if (Character.isJavaIdentifierStart(ch)) {
				String identifier = consumeIdentifier(xInfo);
				stack.push(new DNode(identifier));
			} else if (Character.isDigit(ch)) {
				Number numder = consumeNumber(xInfo);
				queue.add(new DNode(numder));
			} else if (ch == '\'') {
				String literal = consumeLiteral(xInfo);
				stack.push(new DNode(literal));
			}
		}

		System.out.println("Stack :" + stack);
		System.out.println("Queue :" + queue);
	}

	private static String consumeLiteral(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder("'");
		for (; xInfo.hasNext() && xInfo.currChar() != '\''; xInfo.next()) {
			sb.append(xInfo.currChar());
		}
		return sb.toString();
	}

	private static Number consumeNumber(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder();
		for (; xInfo.hasNext() && Character.isDigit(xInfo.currChar()) || xInfo.currChar() == '.'; xInfo.next()) {
			sb.append(xInfo.currChar());
		}
		String num = sb.toString();
		if (num.contains(".")) {
			return new Double(num);
		} else {
			return new Integer(num);
		}
	}

	private static String consumeIdentifier(XPInfo xInfo) {
		StringBuilder sb = new StringBuilder();
		for (; xInfo.hasNext() && Character.isJavaIdentifierPart(xInfo.currChar()); xInfo.next()) {
			sb.append(xInfo.currChar());
		}
		return sb.toString();
	}

	private static void throwInvalidTokenException(XPInfo xInfo) {
		throw new RuntimeException("Invalid token " + xInfo.currChar() + "at location :" + xInfo.getLocation());
	}
}
