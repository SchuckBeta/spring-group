/**
 * .
 */

package com.example.ms.builder;

import com.example.ms.builder.Config.Builder;
import com.example.ms.builder.ConfigGzq.BuilderGzq;
import com.example.ms.builder.impl.AdminMbuilder;
import com.example.ms.builder.impl.FrontMbuilder;

/**
 * .
 * @author chenhao
 *
 */
public class BuilderMain {
    public static void main(String[] args) {
        builder();
        builderGzq();
        builderMenu();
    }

    private static void builderMenu() {
        Mbdirector directora = new Mbdirector(new AdminMbuilder());
        Menu menua = directora.create();
        System.out.println(menua.toString());
        Mbdirector directorf = new Mbdirector(new FrontMbuilder());
        Menu menuf = directorf.create();
        System.out.println(menuf.toString());
    }

    private static void builderGzq() {
        BuilderGzq builder = new BuilderGzq();
        ConfigGzq cb = builder
                .ip("127.0.0.1")
                .port("8080")
                .protocol("http")
                .build();
        System.out.println(cb.toString());
    }

    private static void builder() {
        Builder builder = new Builder();
        Config cb = builder
                .ip("127.0.0.1")
                .port("8080")
                .protocol("http")
                .build();
        System.out.println(cb.toString());
    }
}
