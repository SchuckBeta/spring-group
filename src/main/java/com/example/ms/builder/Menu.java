/**
 * .
 */

package com.example.ms.builder;

/**
 * .
 * @author chenhao
 *
 */
public class Menu {
    private String name;//名称
    private String client;//客户端
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
    @Override
    public String toString() {
        return "Menu [name=" + name + ", client=" + client + "]";
    }
}
