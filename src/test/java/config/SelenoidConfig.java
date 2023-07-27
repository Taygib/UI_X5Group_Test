package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:selenoid.properties"})
public interface SelenoidConfig extends Config {

    @Key("userName")
    String login();

    @Key("password")
    String password();

    @Key("selenoidUrl")
    String url();
}