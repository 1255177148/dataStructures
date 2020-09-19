package com.zhan.data.expression;


import com.zhan.data.util.CalculationUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author Zhanzhan
 * @Date 2020/9/19 14:38
 * 后缀表达式
 */
public class PostfixExpression {

    /**
     * 计算给定的后缀表达式的结果，
     * 步骤：
     * 1、依次扫描表达式每个元素；
     * 2、如果遇到运算数(数字)，则直接入栈；
     * 3、如果遇到运算符，则从栈中弹出两个运算数(数字)，与此运算符进行计算，将计算的结果入栈；
     * 4、最后留到栈中的数字，就是计算的结果
     * @param list 给定的后缀表达式，事先要转为数组，便于遍历
     * @return 计算结果
     */
    public String calculation(List<String> list){
        if (CollectionUtils.isEmpty(list)){
            throw new RuntimeException("给定的表达式有错");
        }
        Stack<String> stack = new Stack<>();
        // 遍历集合，将数据压入栈中，如果遇到运算符，则从栈中pop出两个数据进行运算，将运算结果再压入栈中
        for (String item : list){
            if (item.matches("^([-+])?\\d+(\\.\\d+)?$")){ //正则表达式，匹配数字
                stack.push(item);
            } else {
                String num1 = stack.pop();
                String num2 = stack.pop();
                String result = CalculationUtil.calculation(num1, num2, item);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    /**
     * 中缀表达式如何转后缀表达式
     * 1、初始化两个栈，一个存储扫描的运算符的栈s1，一个是存储最终转换的后缀表达式的栈s2，当然，如果没有线程安全的需求，
     * 存储后缀表达式的栈可以用ArrayList代替；
     * 2、从左到右扫描表达式；
     * 3、如果遇到操作数(数字)，将其放入s2栈；
     * 4、如果遇到运算符，会有以下场景：
     *  1) 如果s1栈为空，或者s1栈顶的运算符为左括号"("，则直接将此运算符入栈，
     *  2) 1不满足的话，则比较优先级，如果优先级比栈顶的运算符高，则将此运算符入栈，
     *  3) 否则，将s1栈顶的运算符弹出，压入s2，然后再次转到4-1) 步骤开始比较。
     * 5、如果遇到括号时，会有以下场景：
     *  1) 如果是左括号"("，则直接入栈，
     *  2) 如果是右括号")"，则依次弹出s1栈顶的运算符，压入s2栈，直到弹出一个左括号为止，然后将此左右两个括号丢弃。
     * 6、重复步骤2至5，一直到扫描完表达式
     * 7、将s1栈中剩余的运算符依次弹出并压入s2栈
     * 8、依次将s2中的元素弹出，然后将弹出的结果逆序输出，即为此中缀表达式对应的后缀表达式
     * @param expression 要转换的中缀表达式
     * @return 转换后的后缀表达式
     */
    public List<String> conversionToPostfix(String expression){
        // 先将中缀表达式转为list，方便遍历
        List<String> list = toExpressionList(expression);
        if (CollectionUtils.isEmpty(list)){
            return new ArrayList<>();
        }
        List<String> resultList = new ArrayList<>(); // 存放最终的后缀表达式
        Stack<String> tempStack = new Stack<>(); // 临时存放运算符
        for (String item : list){
            if (item.matches("^([-+])?\\d+(\\.\\d+)?$")){ // 如果是数字
                resultList.add(item);
            } else if (item.equals("(")){
                tempStack.push(item);
            } else if (item.equals(")")){
                while (!tempStack.peek().equals("(")){
                    resultList.add(tempStack.pop());
                }
                tempStack.pop();
            } else if (CalculationUtil.isPriority(item)){ // 如果是运算符
                while (!tempStack.isEmpty() && CalculationUtil.getPriority(item) <= CalculationUtil.getPriority(tempStack.peek())){
                    resultList.add(tempStack.pop());
                }
                tempStack.push(item);
            } else {
                throw new RuntimeException("表达式格式错误，只能包含数字、小括号和运算符");
            }
        }
        while (!tempStack.isEmpty()){
            resultList.add(tempStack.pop());
        }
        return resultList;
    }

    /**
     * 将表达式转换为对应的list
     * @param str 表达式
     * @return
     */
    public List<String> toExpressionList(String str){
        List<String> list = new ArrayList<>();
        int index = 0;
        String item;
        StringBuffer sb = new StringBuffer();
        String pre = "";// 表示上一个存入list中的数据
        while (index < str.length()){
            if (sub(str, index).matches("\\d")){
                // 如果是多位数，则循环拼接
                sb.setLength(0); // 清空sb
                while (isNumber(str, index)){
                    sb.append(sub(str, index));
                    index++;
                }
                pre = sb.toString();;
                if (!pre.matches("^([-+])?\\d+(\\.\\d+)?$")){
                    throw new RuntimeException("表达式格式错误，只能包含数字、小括号和运算符");
                }
                list.add(pre);
            } else {
                // 是运算符的话直接就放入List
                // 如果是负数，则要将"-"和后面的数字拼接，然后放入
                if (isNegativeNumber(str, index, pre)){
                    sb.setLength(0);
                    sb.append(sub(str, index));
                    index++;
                    while (isNumber(str, index)){
                        sb.append(sub(str, index));
                        index++;
                    }
                    pre = sb.toString();
                    if (!pre.matches("^([-+])?\\d+(\\.\\d+)?$")){
                        throw new RuntimeException("表达式格式错误，只能包含数字、小括号和运算符");
                    }
                    list.add(pre);
                } else {
                    pre = sub(str, index);
                    list.add(pre);
                    index++;
                }
            }
        }
        return list;
    }

    /**
     * 判断是否为数字，包括小数
     * @param expression 当前表达式
     * @param index 当前表达式的下标
     * @return
     */
    private boolean isNumber(String expression, int index){
        if (index >= expression.length()){
            return false;
        }
        String current = sub(expression, index);
        return current.matches("\\d") || current.equals(".");
    }

    /**
     * 用来识别是否为负数，
     * 识别依据：
     *  1、当前字符为"-"且前一位为"("，后一位为数字；
     *  2、当前字符为"-"，且处于字符串的首位
     * @param expression 当前表达式
     * @param index 要截取的开始下标
     * @param pre 上一个存入list中的数据
     * @return
     */
    private boolean isNegativeNumber(String expression, int index, String pre){
        if (index >= expression.length() - 1){
            return false;
        }
        String current = sub(expression, index);
        String latter = sub(expression, index + 1);
        return current.equals("-") && latter.matches("\\d") && (index == 0 || "(".equals(pre));
    }

    private String sub(String str, int index){
        return str.substring(index, index + 1);
    }

    public static void main(String[]args){
        String str = "0.3";
        System.out.println(str.matches("^([-+])?\\d+(\\.\\d+)?$"));
    }
}
