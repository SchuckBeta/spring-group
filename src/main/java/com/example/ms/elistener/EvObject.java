/**
 * .
 */

package com.example.ms.elistener;

import java.util.EventObject;

/**
 * .
 * @author chenhao
 *
 */
public class EvObject extends EventObject{
    private static final long serialVersionUID = 1L;

    public EvObject(Object source) {
        super(source);
    }

    /**
     * 时间通知.
     */
    public void todo() {
        System.out.println("处理了一个事件！");
    }
}
