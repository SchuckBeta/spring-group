/**
 * .
 */

package com.example.ms.elistener;

/**
 * .
 * @author chenhao
 *
 */
public class EvMain {
    public static void main(String[] args) {
//        evRes();
        evResWindow();
    }

    private static void evResWindow() {
        EvResWindow evr = new EvResWindow();
        evr.onCloseWindow(new IEvListener() {
            @Override
            public void handleEv(EvObject evo) {
                evo.todo();
                if((evo.getSource()).equals("CloseWindow")){
                    System.out.println("Close Window!!!");
                }else if((evo.getSource()).equals("OpenWindow")){
                    System.out.println("Open Window!!!");
                }else{
                    System.out.println("DEFAULT EVENT!!!");
                }
            }
        });
        evr.doCloseWindow();
    }

    private static void evRes() {
        EvRes evr = new EvRes();
        evr.add(new IEvListener() {
            @Override
            public void handleEv(EvObject evo) {
                evo.todo();
                if((evo.getSource()).equals("CloseWindow")){
                    System.out.println("Close Window!!!");
                }else if((evo.getSource()).equals("OpenWindow")){
                    System.out.println("Open Window!!!");
                }else{
                    System.out.println("DEFAULT EVENT!!!");
                }
            }
        });

        evr.notifyEvs(new EvObject("CloseWindow"));
        evr.notifyEvs(new EvObject("OpenWindow"));
    }
}
