package com.nali.sd.key;

import com.nali.sd.system.Reference;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class KeyTick
{
    public static int WIDTH;
    public static int HEIGHT;

    @SubscribeEvent
    public static void setGuiScreenEvent(GuiScreenEvent.DrawScreenEvent.Post event)
    {
        WIDTH = event.getGui().width;
        HEIGHT = event.getGui().height;
//        if (!SakuraDrop.SAKURADROP_MAP.isEmpty())
//        {
//            Set<Integer> keys_set = new HashSet<>(SakuraDrop.SAKURADROP_MAP.keySet());
//            for (Integer id : keys_set)
//            {
//                SakuraDrop.SAKURADROP_MAP.get(id).render(WIDTH, HEIGHT);
//            }
//        }
    }

//    @SubscribeEvent
//    public static void setRenderTickEvent(TickEvent.RenderTickEvent event)
//    {
//        if (!SakuraDropData.SAKURADROPGUIDATA_MAP.isEmpty())
//        {
//            Set<Integer> keys_set = new HashSet<>(SakuraDropData.SAKURADROPGUIDATA_MAP.keySet());
//            for (Integer id : keys_set)
//            {
//                SakuraDropData sakuradropdata = SakuraDropData.SAKURADROPGUIDATA_MAP.get(id);
//                sakuradropdata.screen_float_array[0] = WIDTH;
//                sakuradropdata.screen_float_array[1] = HEIGHT;
//                sakuradropdata.render();
//            }
//        }
//    }
}
