package com.nali.sd.mixin;

import com.nali.data.SakuraDropData;
import com.nali.sd.data.SakuraData;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static com.nali.Nali.RANDOM;
import static com.nali.sd.entities.EntitiesRenderHelper.DATALOADER;
import static com.nali.sd.key.KeyTick.HEIGHT;
import static com.nali.sd.key.KeyTick.WIDTH;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
//    private int tick;
//    private int key;
    private static boolean[] CLICK;
//    private long last_time;

    @Inject(method = "runTick", at = @At("HEAD"))
    private void runTick(CallbackInfo ci)
    {
        if (CLICK == null)
        {
            CLICK = new boolean[Mouse.getButtonCount()];
        }
        Minecraft minecraft = Minecraft.getMinecraft();
//        ScaledResolution scaledresolution = new ScaledResolution(minecraft);
//        WIDTH = scaledresolution.getScaledWidth();
//        HEIGHT = scaledresolution.getScaledHeight();
//        while (Mouse.next())
//        {
//        int i = Mouse.getEventButton();
        for (int i = 0; i < Mouse.getButtonCount(); ++i)
        {
            //        if (Mouse.getEventButtonState())//click
            boolean down = Mouse.isButtonDown(i);

            if (down)
            {
                CLICK[i] = true;
            }
            else if (!down && CLICK[i])
            {
                CLICK[i] = false;
//            if (this.tick++ > 0)
//            {
//                return;
//            }

//            this.key = i;
//            this.last_time = Minecraft.getSystemTime();
//        }
//        if (i != -1 && this.key != -1)//release
//        {
//            if (--this.tick > 0)
//            {
//                return;
//            }

//            this.key = -1;
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
//            SD.LOGGER.info("X " + x);
//            SD.LOGGER.info("Y " + y);
//            SD.LOGGER.info("Width " + WIDTH);
//            SD.LOGGER.info("Height " + HEIGHT);

                SakuraDropData sakuradropdata = new SakuraDropData(new SakuraData(), DATALOADER);
                sakuradropdata.texture_index_int_array[0] = RANDOM.nextInt(((Object[])DATALOADER.texture_object_array[0]).length);
                sakuradropdata.screen_float_array[2] = x;
                sakuradropdata.screen_float_array[3] = y;
            }
//        else if (this.key != -1 && this.last_time > 0L)//move
//        {
//            long l = Minecraft.getSystemTime() - this.last_time;
//        }
//        }
        }
    }
}
