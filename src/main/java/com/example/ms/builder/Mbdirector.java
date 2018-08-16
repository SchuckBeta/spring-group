/**
 * .
 */

package com.example.ms.builder;

/**
 * .
 * @author chenhao
 *
 */
public class Mbdirector {
    private IMbuilder builder;

    public Mbdirector(IMbuilder builder) {
        super();
        this.builder = builder;
    }

    /**
     * 生成一个菜单.
     * @return
     */
    public Menu create() {
        return this.builder.name().client()
                .builder();
    }
}
