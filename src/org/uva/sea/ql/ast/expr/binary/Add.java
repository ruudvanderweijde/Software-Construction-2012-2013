package org.uva.sea.ql.ast.expr.binary;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.type.NumericType;
import org.uva.sea.ql.type.Type;
import org.uva.sea.ql.visitor.IExpressionVisitor;
import org.uva.sea.ql.visitor.typeChecker.TypeMapper;

public class Add extends Binary {

	public Add(Expr lhs, Expr rhs) {
		super(lhs, rhs);
	}

	@Override
	public String toString() {
		return " + ";
	}

	@Override
	public Type typeOf(TypeMapper typeMapper) {
		return new NumericType();
	}

	@Override
	public <T> T accept(IExpressionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
