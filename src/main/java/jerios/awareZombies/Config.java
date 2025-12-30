package jerios.awareZombies;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class Config {

    public static int aiPir = -999;
    
    public static int trackRange;
    
    public static int updateFreq;
    
    public static int mutexBits;
    
    
    private static final int MIN = Integer.MIN_VALUE;
    private static final int MAX = Integer.MAX_VALUE;
    
    private static final String PNAME = "Config";

    public static void synchronizeConfiguration(File configFile) {
        Configuration configuration = new Configuration(configFile);

        aiPir = configuration.getInt(PNAME, Configuration.CATEGORY_GENERAL, -9999, MIN, MAX, "AI PIR");
        trackRange = configuration.getInt(PNAME, Configuration.CATEGORY_GENERAL, 32, MIN, MAX, "Blood tracking range");
        updateFreq = configuration.getInt(PNAME, Configuration.CATEGORY_GENERAL, 20, MIN, MAX, "Blood update freq");
        
        mutexBits = configuration.getInt(PNAME, Configuration.CATEGORY_GENERAL, 14, MIN, MAX, "Blood update freq");
        
        
        
        
        if (configuration.hasChanged()) {
            configuration.save();
        }
    }
}
