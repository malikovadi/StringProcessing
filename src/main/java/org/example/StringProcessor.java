package org.example;
import java.util.Stack;

public class StringProcessor
{
    public boolean isStrongPassword(String password)
    {
        boolean isUpperCase = false;
        boolean isLowerCase = false;
        boolean isDigit = false;
        boolean isSpecialSymbol = false;
        for(int i = 0; i < password.length(); i++)
        {
            char character = password.charAt(i);
            if(character >= 65 && character <= 90)
            {
                isUpperCase = true;
            }
            if(character >= 97 && character <= 122)
            {
                isLowerCase = true;
            }
            if(character >= 48 && character <= 57)
            {
                isDigit = true;
            }
            if(character >= 33 && character <= 47 || character >= 58 && character <=64)
            {
                isSpecialSymbol = true;
            }
        }
        return isUpperCase && isLowerCase && isDigit && isSpecialSymbol;
    }

    public int calculateDigits(String sentence)
    {
        int digitCounter = 0;
        for(int i = 0; i < sentence.length(); i++)
        {
            char character = sentence.charAt(i);
            if(character >= 48 && character <= 57)
            {
                digitCounter++;
            }
        }
        return digitCounter;
    }

    public int calculateWords(String sentence) {
        int wordCounter = 0;
        boolean inWord = false;

        for (int i = 0; i < sentence.length(); i++) {
            char character = sentence.charAt(i);

            if (Character.isWhitespace(character)) {
                // If whitespace, mark that we are not in a word
                inWord = false;
            } else {
                // If not whitespace, and not already in a word, increment word count
                if (!inWord) {
                    wordCounter++;
                    inWord = true;
                }
            }
        }   
        return wordCounter;
    }


    public double calculateExpression(String expression) {
        Stack<Double> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (Character.isDigit(character)) {
                // If the current character is a digit, extract the whole number
                char[] numArray = new char[expression.length()];
                int numIndex = 0;
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    numArray[numIndex++] = expression.charAt(i);
                    i++;
                }
                i--; // Decrement i to handle the next character in the next iteration

                // Convert the extracted number to a double and push it onto the numbers stack\
                String numString = new String(numArray, 0, numIndex);
                double numValue = Double.parseDouble(numString);
                numbers.push(numValue);
            } else if (character == '+' || character == '-' || character == '*' || character == '/') {
                // If the current character is an operator, push it onto the operators stack
                operators.push(character);
            } else if (character == '(') {
                // If the current character is an opening bracket, push it onto the operators stack
                operators.push(character);
            } else if (character == ')') {
                // If the current character is a closing bracket, evaluate the expression
                while (!operators.isEmpty() && operators.peek() != '(') {
                    evaluateExpression(numbers, operators);
                }
                operators.pop(); // Pop the '(' from the operators stack
            }
        }

        // Evaluate any remaining operators in the stacks
        while (!operators.isEmpty()) {
            evaluateExpression(numbers, operators);
        }

        // The result should be the only element left in the numbers stack
        return numbers.pop();
    }

    private void evaluateExpression(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double operand2 = numbers.pop();
        double operand1 = numbers.pop();

        switch (operator) {
            case '+':
                numbers.push(operand1 + operand2);
                break;
            case '-':
                numbers.push(operand1 - operand2);
                break;
            case '*':
                numbers.push(operand1 * operand2);
                break;
            case '/':
                numbers.push(operand1 / operand2);
                break;
        }
    }
}