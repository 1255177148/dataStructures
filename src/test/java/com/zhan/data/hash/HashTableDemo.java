package com.zhan.data.hash;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Scanner;

/**
 * @Author zhan
 * @Date 2020/10/8 16:13
 * hash表demo
 */
@SpringBootTest
public class HashTableDemo {

    @Test
    void demo() {
        HashTable<Integer, String> hashTable = new HashTable<Integer,String>();
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("a : 添加数据");
            System.out.println("l : 遍历数据");
            System.out.println("g : 查找数据");
            System.out.println("r : 删除数据");
            System.out.println("e : 退出");
            System.out.println("请选择功能:");
            input = scanner.next();
            int key;
            switch (input) {
                case "a":
                    System.out.println("输入key :");
                    key = scanner.nextInt();
                    System.out.println("输入value :");
                    String value = scanner.next();
                    hashTable.add(hashTable.buildNode(key, value));
                    break;
                case "l":
                    hashTable.list();
                    break;
                case "g":
                    System.out.println("输入要查找的key:");
                    key = scanner.nextInt();
                    System.out.println("查找到的值为:" + hashTable.get(key));
                    break;
                case "r":
                    System.out.println("输入要删除的key :");
                    key = scanner.nextInt();
                    boolean flag = hashTable.remove(key);
                    if (flag){
                        System.out.println("已删除");
                    } else {
                        System.out.println("删除失败");
                    }
                    break;
                case "e":
                    scanner.close();
                    System.out.println("退出程序");
                    return;
                default:
                    break;
            }
        }
    }
}
