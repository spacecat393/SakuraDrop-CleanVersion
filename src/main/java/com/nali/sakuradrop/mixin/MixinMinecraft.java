package com.nali.sakuradrop.mixin;

import com.nali.sakuradrop.render.SakuraDropRender;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

import static com.nali.sakuradrop.key.KeyTick.FUNCTION;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
//    @Shadow public abstract void resize(int width, int height);

    @Inject(method = "runTick", at = @At("HEAD"))
    private void runTick(CallbackInfo ci)
    {
        FUNCTION.apply(null);
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
}