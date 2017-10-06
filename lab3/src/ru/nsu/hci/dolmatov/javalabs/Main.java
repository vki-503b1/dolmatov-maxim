package ru.nsu.hci.dolmatov.javalabs;

import java.util.LinkedList;

public class Main {

    public boolean isOperator(char c) {

        if (c == '+' || c == '-' || c == '*' || c == '/')
            return true;
        else
            return false;
    }

    int priority(char oper) {

        if (oper == '*' || oper == '/')
            return 1;
        else if (oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }

    void letsGo(LinkedList<Integer> st, char oper) {

        int someOne = st.removeLast();
        int someTwo = st.removeLast();

        switch(oper) {
            case '+':
                st.add(someTwo + someOne);
                break;
            case '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Ошибка!");
        }
    }

    int eval(String s) {

        LinkedList<Integer> someInts = new LinkedList<>();
        LinkedList<Character> someOpers = new LinkedList<>();

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c == '(')
                someOpers.add('(');

            else if (c == ')') {

                while(someOpers.getLast() != '(') {
                    letsGo(someInts, someOpers.removeLast());
                }
                someOpers.removeLast();
            }

            else if (isOperator(c)) {
                while(!someOpers.isEmpty() && priority(someOpers.getLast()) >= priority(c)) {

                    letsGo(someInts, someOpers.removeLast());
                }

                someOpers.add(c);
            }

            else {
                String operand = "";

                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    operand += s.charAt(i++);
                }

                --i;
                someInts.add(Integer.parseInt(operand));
            }
        }

        while(!someOpers.isEmpty()) {

            letsGo(someInts, someOpers.removeLast());
        }

        return someInts.get(0);
    }

    public static void main(String[] args) {

    }
}
