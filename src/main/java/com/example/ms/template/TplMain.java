/**
 * .
 */

package com.example.ms.template;

import com.example.ms.template.impl.TplAaa;
import com.example.ms.template.impl.TplBbb;

/**
 * .
 * @author chenhao
 *
 */
public class TplMain {
    public static void main(String[] args) {
        TplAaa ta = new TplAaa();
        ta.run();

        TplBbb tb = new TplBbb();
        tb.run();
    }
}
