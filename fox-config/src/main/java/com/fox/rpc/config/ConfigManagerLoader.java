package com.fox.rpc.config;

import com.fox.rpc.common.extension.UserServiceLoader;
import org.apache.log4j.Logger;

/**
 * Created by shenwenbo on 2016/10/17.
 */
public class ConfigManagerLoader {

    private static ConfigManager configManager = UserServiceLoader.getExtension(ConfigManager.class);

    private static final Logger logger = Logger.getLogger(ConfigManagerLoader.class);

    static {
        if (configManager == null) {
            configManager = new PropertiesFileConfigManager();
        }
        logger.info("config manager:" + configManager);
        configManager.init();
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }

}
