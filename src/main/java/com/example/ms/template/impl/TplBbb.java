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
public class TplBbb extends AbsTpl{

    @Override
    public void stepA() {
        System.out.println("TplBbb 执行了A步");
    }

    @Override
    public void stepB() {
        System.out.println("TplBbb 执行了B步");
    }

    @Override
    public void stepC() {
        System.out.println("TplBbb 执行了C步");
    }
}
