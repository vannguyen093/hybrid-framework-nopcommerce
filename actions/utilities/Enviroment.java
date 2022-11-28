package utilities;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:enviromentConfig/${env}.properties"})
public interface Enviroment extends Config {
    @Key("App.Url")
    String appUrl();

    @Key("App.User")
    String appUser();

    @Key("App.Pass")
    String appPass();
}
