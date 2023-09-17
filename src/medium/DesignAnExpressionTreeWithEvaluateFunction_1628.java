package medium;

public class DesignAnExpressionTreeWithEvaluateFunction_1628 {
    // https://leetcode.com/problems/design-an-expression-tree-with-evaluate-function/submissions/1051659876/

    abstract class Node {
        public abstract int evaluate();
        // define your fields here
    }


    class TreeNode extends Node {
        String value;
        boolean isOperand;
        TreeNode left;
        TreeNode right;

        public TreeNode(String value) {
            this.value = value;
            isOperand = value.equals("+")
                    || value.equals("-")
                    || value.equals("/")
                    || value.equals("*");
        }

        public int evaluate() {
            if (!isOperand) return Integer.valueOf(value);
            int leftVal = 0;
            if (left != null) leftVal += left.evaluate();
            int rightVal = 0;
            if (right != null) rightVal += right.evaluate();
            return operate(leftVal, rightVal);
        }


        private int operate(int leftVal, int rightVal) {
            switch (value) {
                case "+":
                    return leftVal + rightVal;
                case "-":
                    return leftVal - rightVal;
                case "/":
                    return leftVal / rightVal;
                default:
                    return leftVal * rightVal;
            }
        }
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {

        String[] postfix;
        int index;

        Node buildTree(String[] postfix) {
            this.index = postfix.length - 1;
            this.postfix = postfix;
            return buildTree();
        }

        TreeNode buildTree() {
            if (index < 0) return null;
            TreeNode node = new TreeNode(postfix[index--]);
            if (!node.isOperand) return node;
            node.right = buildTree();
            node.left = buildTree();
            return node;
        }

    }

}
