/**
 * .
 */

package com.example.ms.call;

import com.example.ms.call.impl.CallImpAaa;
import com.example.ms.call.impl.CallImpBbb;

/**
 * .
 * @author chenhao
 *
 */
public class CallMain {
    public static void main(String[] args) {
        Caller caller = new Caller();
        caller.run(new CallImpAaa());
        caller.run(new CallImpBbb());

        caller.run(new ICall() {
            @Override
            public void call() {
                System.out.println("-------------接口实现执行了");
            }
        });

        ICall icall = new ICall() {
            @Override
            public void call() {
                System.out.println("-------------接口ICall实现执行了");
            }
        };
        caller.run(icall);
    }
}
