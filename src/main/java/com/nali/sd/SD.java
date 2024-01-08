package com.nali.sd;

import com.nali.sd.system.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class SD
{
    @Instance
    public static SD I;

    public static Logger LOGGER;

    @EventHandler
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();
    }
}
