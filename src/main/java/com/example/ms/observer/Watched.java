/**
 * .
 */

package com.example.ms.observer;

import java.util.Observable;

/**
 * .
 * @author chenhao
 *
 */
public class Watched extends Observable{
    /* (non-Javadoc)
     * @see java.util.Observable#notifyObservers(java.lang.Object)
     */
    @Override
    public void notifyObservers(Object arg) {
        super.setChanged();
        super.notifyObservers(arg);
    }
}
