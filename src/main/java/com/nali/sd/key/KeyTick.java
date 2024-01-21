package com.nali.sd.key;

import com.nali.render.SakuraDropRender;
import com.nali.sd.config.MyConfig;
import com.nali.sd.render.RenderHelper;
import com.nali.sd.system.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;

import java.util.function.Function;

import static com.nali.Nali.RANDOM;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class KeyTick
{
    public static Function FUNCTION = (v) -> v;
    public static int WIDTH;
    public static int HEIGHT;

    public static boolean[] CLICK;
    public static boolean LC, RC;

    public static Void mainRun()
    {
        Minecraft minecraft = Minecraft.getMinecraft();

        if (MyConfig.ON_WORLD || minecraft.currentScreen != null)
        {
            boolean lc = minecraft.gameSettings.keyBindAttack.isKeyDown();
            boolean rc = minecraft.gameSettings.keyBindUseItem.isKeyDown();

            if (lc || rc)
            {
                if ((!LC && lc) || (!RC && rc))
                {
                    render(minecraft);
                    LC = lc;
                    RC = rc;
                }
            }
            else
            {
                LC = false;
                RC = false;

                if (CLICK == null)
                {
                    CLICK = new boolean[Mouse.getButtonCount()];
                }

                for (int i = 0; i < Mouse.getButtonCount(); ++i)
                {
                    boolean down = Mouse.isButtonDown(i);

                    if (down && !CLICK[i])
                    {
                        CLICK[i] = true;
                        render(minecraft);
                    }
                    else if (!down)
                    {
                        CLICK[i] = false;
                    }
                }
            }
        }

        return null;
    }

    public static void render(Minecraft minecraft)
    {
//        Item item = Item.getItemById(RANDOM.nextInt(Item.REGISTRY.getKeys().size()));
//        ResourceLocation resourcelocation = item.getRegistryName();
//
//        if (resourcelocation != null)
//        {
//            String namespace = resourcelocation.getNamespace();
//            String path = "textures/items/" + resourcelocation.getPath() + ".png";
//            resourcelocation = new ResourceLocation(namespace, path);
//
        int x, y;
        if (minecraft.currentScreen == null)
        {
            x = WIDTH / 2;
            y = HEIGHT / 2;
        }
        else
        {
            x = Mouse.getEventX() * WIDTH / minecraft.displayWidth;
            y = HEIGHT - Mouse.getEventY() * HEIGHT / minecraft.displayHeight - 1;
        }
//
//            TextureManager texturemanager = minecraft.getTextureManager();
//            ITextureObject itextureobject = texturemanager.getTexture(resourcelocation);
//            if (itextureobject == null)
//            {
//                itextureobject = new SimpleTexture(resourcelocation);
//                texturemanager.loadTexture(resourcelocation, itextureobject);
//            }
//
//            if (itextureobject != null)
//            {
//                SakuraDropRender sakuradroprender = new SakuraDropRender(itextureobject.getGlTextureId());
        int index = RANDOM.nextInt(RenderHelper.OPENGLTEXTUREMEMORY.texture_array.length);
        SakuraDropRender sakuradroprender = new SakuraDropRender((int)RenderHelper.OPENGLTEXTUREMEMORY.texture_array[index], RenderHelper.OPENGLTEXTUREMEMORY.width_int_array[index], RenderHelper.OPENGLTEXTUREMEMORY.height_int_array[index]);
        sakuradroprender.x = x;
        sakuradroprender.y = y;
//            }
//        }
    }

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
