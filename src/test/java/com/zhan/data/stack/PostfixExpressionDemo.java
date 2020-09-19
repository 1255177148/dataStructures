package com.zhan.data.stack;

import com.zhan.data.expression.PostfixExpression;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author zhan
 * @Date 2020/9/18 19:49
 * 一个简单的后缀表达式(逆波兰表达式)demo
 */
@SpringBootTest
public class PostfixExpressionDemo {

    /**
     * 主要测试后缀表达式如何计算，并得到结果
     * 后缀表达式，依次扫描表达式，如果是数字(运算数),则直接入栈,
     * 如果是运算符，则从栈中pop出两个数字(运算符)，进行计算，将计算的结果再入栈,
     * 就这样直到表达式的结尾
     */
    @Test
    void calculation() {
        // 先定义一个后缀表达式
        String expression = "30 4 + 2 * 2 - 2 /";

        PostfixExpression postfixExpression = new PostfixExpression();
        String result = postfixExpression.calculation(Arrays.asList(expression.split(" ")));
        System.out.printf("表达式%s=%s", expression, result);
    }

    /**
     * 中缀表达式如何转后缀表达式
     * 1、初始化两个栈，一个存储扫描的运算符的栈s1，一个是存储最终转换的后缀表达式的栈s2，当然，如果没有线程安全的需求，
     * 存储后缀表达式的栈可以用ArrayList代替；
     * 2、从左到右扫描表达式；
     * 3、如果遇到操作数(数字)，将其放入s2栈；
     * 4、如果遇到运算符，会有以下场景：
     * 1) 如果s1栈为空，或者s1栈顶的运算符为左括号"("，则直接将此运算符入栈，
     * 2) 1不满足的话，则比较优先级，如果优先级比栈顶的运算符高，则将此运算符入栈，
     * 3) 否则，将s1栈顶的运算符弹出，压入s2，然后再次转到4-1) 步骤开始比较。
     * 5、如果遇到括号时，会有以下场景：
     * 1) 如果是左括号"("，则直接入栈，
     * 2) 如果是右括号")"，则依次弹出s1栈顶的运算符，压入s2栈，直到弹出一个左括号为止，然后将此左右两个括号丢弃。
     * 6、重复步骤2至5，一直到扫描完表达式
     * 7、将s1栈中剩余的运算符依次弹出并压入s2栈
     * 8、依次将s2中的元素弹出，然后将弹出的结果逆序输出，即为此中缀表达式对应的后缀表达式
     */
    @Test
    void conversionToPostfix() {
        String expression = "-5+(30*(4-2)/3)+(-8.5)";
        PostfixExpression postfixExpression = new PostfixExpression();
        List<String> list = postfixExpression.conversionToPostfix(expression);
        System.out.println(list);
        String result = postfixExpression.calculation(list);
        System.out.printf("表达式%s=%s", expression, result);
    }
}
