/**
 * .
 */

package com.example.ms.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * .
 * @author chenhao
 *
 */
public class IWatcher implements Observer{
    @Override
    public void update(Observable o, Object arg) {
        if(("OpenWindow").equals(arg.toString())){
            System.out.println("打开窗口！！");
        }else if(("CloseWindow").equals(arg.toString())){
            System.out.println("关闭窗口！！");
        }
    }
}
