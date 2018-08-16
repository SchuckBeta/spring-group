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
public class AdminMbuilder implements IMbuilder{
    private Menu menu;

    public AdminMbuilder() {
        super();
        this.menu = new Menu();
    }

    @Override
    public Menu builder() {
        return this.menu;
    }

    @Override
    public AdminMbuilder name() {
        this.menu.setName("后台菜单");
        return this;
    }

    @Override
    public AdminMbuilder client() {
        this.menu.setClient("/a");
        return this;
    }
}
