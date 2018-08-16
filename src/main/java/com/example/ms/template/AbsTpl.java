/**
 * .
 */

package com.example.ms.template;

/**
 * .
 *
 * @author chenhao
 *
 */
public abstract class AbsTpl {
    protected void run() {
        stepA();
        stepB();
        stepC();
    }

    public abstract void stepA();
    public abstract void stepB();
    public abstract void stepC();
}
