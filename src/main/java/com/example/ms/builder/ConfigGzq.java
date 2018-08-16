/**
 * .
 */

package com.example.ms.builder;

/**
 * .
 * @author chenhao
 *
 */
public class ConfigGzq {
    private String protocol;
    private String ip;
    private String port;

    public ConfigGzq() {
        super();
    }

    public ConfigGzq(ConfigGzq config) {
        super();
        this.protocol = config.protocol;
        this.ip = config.ip;
        this.port = config.port;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getIp() {
        return ip;
    }

    public String getPort() {
        return port;
    }

    @Override
    public String toString() {
        return "ConfigBuilder [protocol=" + protocol + ", ip=" + ip + ", port=" + port + "]";
    }

    //新增Builder静态类并赋默认值
    public static class BuilderGzq {
        private ConfigGzq config;

        public BuilderGzq() {
            super();
            config = new ConfigGzq();
        }

        //为每一个属性创建返回自身Builder对象的方法
        public BuilderGzq protocol(String protocol) {
            config.protocol = protocol;
            return this;
        }

        public BuilderGzq ip(String ip) {
            config.ip = ip;
            return this;
        }

        public BuilderGzq port(String port) {
            config.port = port;
            return this;
        }

        //新建一个build方法，创建一个父类对象，传递给apply方法为这个空对象赋构建出来的参数值，返回这个构建对象即可。
        public ConfigGzq build(){
            return new ConfigGzq(this.config);
        }
    }
}