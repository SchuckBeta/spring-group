/**
 * .
 */

package com.example.ms.elistener;

import java.util.Vector;

/**
 * .
 * @author chenhao
 *
 */
public class EvRes {
    public Vector<IEvListener> listeners = new Vector<IEvListener>();

    /**
     * 注册事件.
     */
    public void add(IEvListener el) {
        listeners.add(el);
    }

    /**
     * 撤销事件.
     */
    public void rm(IEvListener el) {
        listeners.add(el);
    }

    /**
     * 撤销事件.
     */
    public void notifyEvs(EvObject evo) {
        for (IEvListener ev : listeners) {
            ev.handleEv(evo);
        }
    }
}
