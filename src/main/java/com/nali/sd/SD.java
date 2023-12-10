package com.nali.sd;

import com.nali.entities.EntitiesRender;
import com.nali.sd.entities.EntitiesRenderHelper;
import com.nali.sd.system.Reference;
import com.nali.system.DataLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class SD
{
    @Instance
    public static SD SD;

    public static Logger LOGGER;

    @EventHandler
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
    {
        LOGGER = event.getModLog();

        if (event.getSide().isClient())
        {
            EntitiesRender.set();
            DataLoader.setModels(EntitiesRenderHelper.DATALOADER, Reference.MOD_ID, "/OpenGLShaders/", false);
            EntitiesRender.load(EntitiesRenderHelper.DATALOADER);
        }
    }
}
