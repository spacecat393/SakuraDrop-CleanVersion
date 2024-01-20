package com.nali.sd;

import com.nali.sd.system.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class SD
{
    @Instance
    public static SD I;

    public static Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    public static Configuration CONFIGURATION;

    @EventHandler
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
    {
        if (event.getSide().isClient())
        {
            CONFIGURATION = new Configuration(event.getSuggestedConfigurationFile());
            CONFIGURATION.load();
        }
    }
}
