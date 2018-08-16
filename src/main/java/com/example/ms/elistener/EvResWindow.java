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
public class EvResWindow {
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

    public void onCloseWindow(IEvListener evl){
        System.out.println("关闭事件---1");
        listeners.addElement(evl);
    }

    public void doCloseWindow(){
        System.out.println("执行关闭事件---1");
        this.notifyEvs(new EvObject("CloseWindow"));
    }
}
