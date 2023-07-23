package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:selenoid.properties"})
public interface DriverConfig extends Config {

    @Key("userName")
    @DefaultValue("user1")
    String login();

    @Key("password")
    @DefaultValue("1234")
    String password();
}