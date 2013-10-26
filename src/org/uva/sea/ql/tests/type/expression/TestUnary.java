package org.uva.sea.ql.tests.type.expression;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;
import org.uva.sea.ql.message.Message;
import org.uva.sea.ql.parser.ANTLRParser;
import org.uva.sea.ql.parser.IParse;
import org.uva.sea.ql.parser.error.ParseError;
import org.uva.sea.ql.visitor.typeChecker.ExpressionValidator;
import org.uva.sea.ql.visitor.typeChecker.TypeMapper;

public class TestUnary {
	private final IParse parser = new ANTLRParser();
	public static TypeMapper typeMapper = new TypeMapper();
	public static ArrayList<Message> errors = new ArrayList<Message>();

	@Test
	public void testNeg() throws ParseError {
		assertTrue(isValidExpression("-1"));
    	assertFalse(isValidExpression("+true"));	
	}

	@Test
	public void testNot() throws ParseError {
		assertTrue(isValidExpression("!true"));
		assertFalse(isValidExpression("!1"));	
	}
	
	@Test
	public void testPos() throws ParseError {
		assertTrue(isValidExpression("+1"));
		assertFalse(isValidExpression("+true"));	
	}
	
	private boolean isValidExpression(String expression) throws ParseError {
		return parser.parseExpression(expression).accept(new ExpressionValidator(typeMapper, errors));
	}
}
