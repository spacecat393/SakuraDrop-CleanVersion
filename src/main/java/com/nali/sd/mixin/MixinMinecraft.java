package com.nali.sd.mixin;

import com.nali.render.SakuraDropRender;
import com.nali.sd.config.MyConfig;
import com.nali.sd.render.RenderHelper;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

import static com.nali.Nali.RANDOM;
import static com.nali.sd.key.KeyTick.HEIGHT;
import static com.nali.sd.key.KeyTick.WIDTH;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
//    @Shadow public abstract void resize(int width, int height);

    private static boolean[] CLICK;
    private static boolean LC, RC;

    @Inject(method = "runTick", at = @At("HEAD"))
    private void runTick(CallbackInfo ci)
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
                    this.render(minecraft);
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
                        this.render(minecraft);
                    }
                    else if (!down)
                    {
                        CLICK[i] = false;
                    }
                }
            }
        }
    }

    @Inject(method = "runGameLoop", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderStreamIndicator(F)V", shift = At.Shift.AFTER))
    private void runGameLoop(CallbackInfo ci)
    {
        if (!SakuraDropRender.SAKURADROPGUIDATA_MAP.isEmpty())
        {
            Set<Integer> keys_set = new HashSet<>(SakuraDropRender.SAKURADROPGUIDATA_MAP.keySet());
            for (Integer id : keys_set)
            {
                SakuraDropRender sakuradroprender = SakuraDropRender.SAKURADROPGUIDATA_MAP.get(id);
                sakuradroprender.renderScreen(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }

    private void render(Minecraft minecraft)
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
}