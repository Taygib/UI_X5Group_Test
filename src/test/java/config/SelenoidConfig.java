package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:test.properties"})
public interface SelenoidConfig extends Config {

    @Key("selenoid_UserName")
    String login();

    @Key("selenoid_Password")
    String password();

    @Key("selenoid_Url")
    String url();
}