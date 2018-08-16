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
public class WatchMain {
    public static void main(String[] args) {
        Watched wed = new Watched();
        IWatcher wer = new IWatcher();
        wed.addObserver(wer);
        wed.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if(("MaxWindow").equals(arg.toString())){
                    System.out.println("最大化窗口！！");
                }else if(("MinWindow").equals(arg.toString())){
                    System.out.println("最小化窗口！！");
                }
            }
        });

        wed.notifyObservers("OpenWindow");
        wed.notifyObservers("CloseWindow");
        wed.notifyObservers("MaxWindow");
        wed.notifyObservers("MinWindow");
    }
}
