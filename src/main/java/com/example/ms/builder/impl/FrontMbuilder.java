/**
 * .
 */

package com.example.ms.builder.impl;

import com.example.ms.builder.IMbuilder;
import com.example.ms.builder.Menu;

/**
 * .
 * @author chenhao
 *
 */
public class FrontMbuilder implements IMbuilder{
    private Menu menu;

    public FrontMbuilder() {
        super();
        this.menu = new Menu();
    }

    @Override
    public Menu builder() {
        return this.menu;
    }

    @Override
    public FrontMbuilder name() {
        this.menu.setName("前台菜单");
        return this;
    }

    @Override
    public FrontMbuilder client() {
        this.menu.setClient("/f");
        return this;
    }
}
