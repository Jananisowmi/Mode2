package sajib.test.spel;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ExpressionParserExample1 {
	public static void main(String[] args) {
		ExpressionParser expressionParser = new SpelExpressionParser();

		// 1. Literal expression
		Expression expression = expressionParser.parseExpression("'Jaanu'");
		String strVal = expression.getValue(String.class);
		System.out.println("1. Literal expression value:\n" + strVal);

		// 2. Method invocation
		expression = expressionParser.parseExpression("'Jaanu'.concat('velu')");
		strVal = expression.getValue(String.class);
		System.out.println("2. Method invocation value:\n" + strVal);

		// 3. Mathematical operator
		expression = expressionParser.parseExpression("16 * 5");
		Integer intVal = expression.getValue(Integer.class);
		System.out.println("3. Mathematical operator value:\n" + intVal);

		// 4. Relational operator
		expression = expressionParser.parseExpression("5 < 1");
		boolean boolVal = expression.getValue(Boolean.class);
		System.out.println("4. Relational operator value:\n" + boolVal);

		// 5. Logical operator
	 	expression = expressionParser.parseExpression("400 > 200 && 200 < 500");
		boolVal = expression.getValue(Boolean.class);
		System.out.println("5. Logical operator value:\n" + boolVal);

		// 6. Ternary operator
		expression = expressionParser.parseExpression("'janani' == null ? 'some value' : 'default'");
		strVal = expression.getValue(String.class);
		System.out.println("6. Ternary operator value:\n" + strVal);

		// 7. Elvis operator
		expression = expressionParser.parseExpression("'janani' ?: 'default'");
		strVal = expression.getValue(String.class);
		System.out.println("7. Elvis operator value:\n" + strVal);

		// 8. Regex/matches operator
		expression = expressionParser.parseExpression("'janani' matches '[a-z\\s]+'");
		boolVal = expression.getValue(Boolean.class);
		System.out.println("8. Regex/matches operator value:\n" + boolVal);
	}
}
