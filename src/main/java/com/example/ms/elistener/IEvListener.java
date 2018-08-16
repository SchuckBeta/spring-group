/**
 * .
 */

package com.example.ms.elistener;

import java.util.EventListener;

/**
 * .
 * @author chenhao
 *
 */
public interface IEvListener extends EventListener{
    /**
     * 处理事件.
     */
    public void handleEv(EvObject evo);
}
