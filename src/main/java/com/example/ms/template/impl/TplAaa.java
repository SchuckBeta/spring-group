/**
 * .
 */

package com.example.ms.template.impl;

import com.example.ms.template.AbsTpl;

/**
 * .
 * @author chenhao
 *
 */
public class TplAaa extends AbsTpl{

    @Override
    public void stepA() {
        System.out.println("TplAaa 执行了A步");
    }

    @Override
    public void stepB() {
        System.out.println("TplAaa 执行了B步");
    }

    @Override
    public void stepC() {
        System.out.println("TplAaa 执行了C步");
    }
}
