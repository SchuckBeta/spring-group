/**
 * .
 */

package com.example.ms.builder;

/**
 * .
 * @author chenhao
 *
 */
public class Config {
    private String protocol;
    private String ip;
    private String port;

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
    public static class Builder {
        private String protocol;
        private String ip;
        private String port;

        //为每一个属性创建返回自身Builder对象的方法
        public Builder protocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder ip(String ip) {
            this.ip = ip;
            return this;
        }

        public Builder port(String port) {
            this.port = port;
            return this;
        }

        //新建一个build方法，创建一个父类对象，传递给apply方法为这个空对象赋构建出来的参数值，返回这个构建对象即可。
        public Config build(){
            Config config = new Config();
            config.protocol = this.protocol;
            config.ip = this.ip;
            config.port = this.port;
            return config;
        }
    }
}