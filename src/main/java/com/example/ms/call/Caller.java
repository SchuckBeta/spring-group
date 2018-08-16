/**
 * .
 */

package com.example.ms.call;

/**
 * .
 * @author chenhao
 *
 */
public class Caller{

    public void run(ICall callimp) {
        System.out.println("Caller.run执行了！！");
        callimp.call();
        System.out.println("Caller.run执行完成了！！");
    }
}
