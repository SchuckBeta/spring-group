/**
 * .
 */

package com.example.ms.builder;

/**
 * 菜单Builder.
 * @author chenhao
 *
 */
public interface IMbuilder {
    /**
     * 生成菜单.
     */
    Menu builder();

    /**
     * 设置名称.
     */
    IMbuilder name();
    /**
     * 客户端.
     */
    IMbuilder client();
}
