package com.nali.sakuradrop.mixin;

import com.nali.sakuradrop.render.SakuraDropRender;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft
{
//    @Shadow public abstract void resize(int width, int height);

//    @Inject(method = "runTick", at = @At("HEAD"))
//    private void runTick(CallbackInfo ci)
//    {
//        FUNCTION.apply(null);
//    }

//    @Inject(method = "runGameLoop", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderStreamIndicator(F)V", shift = At.Shift.AFTER))
//    private void nali_small_sakuradrop_firstRunGameLoop(CallbackInfo ci)
//    {
//        OPENGL_FIXED_PIPE_FLOATBUFFER.limit(16);
//        GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, OPENGL_FIXED_PIPE_FLOATBUFFER);
//        OpenGlHelper.glUniformMatrix4(openglobjectshadermemory.uniformlocation_int_array[0], false, OPENGL_FIXED_PIPE_FLOATBUFFER);
//        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, OPENGL_FIXED_PIPE_FLOATBUFFER);
//        OpenGlHelper.glUniformMatrix4(openglobjectshadermemory.uniformlocation_int_array[1], false, OPENGL_FIXED_PIPE_FLOATBUFFER);
//        GL11.glGetFloat(GL11.GL_CURRENT_COLOR, OPENGL_FIXED_PIPE_FLOATBUFFER);
//    }

//    @Inject(method = "runGameLoop", at = @At(value = "TAIL"))
    @Inject(method = "runGameLoop", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/EntityRenderer;renderStreamIndicator(F)V", shift = At.Shift.AFTER))
    private void nali_sakuradrop_lastRunGameLoop(CallbackInfo ci)
    {
        if (!SakuraDropRender.SAKURADROPGUIDATA_MAP.isEmpty())
        {
            for (Integer id : new HashSet<>(SakuraDropRender.SAKURADROPGUIDATA_MAP.keySet()))
            {
                SakuraDropRender sakuradroprender = SakuraDropRender.SAKURADROPGUIDATA_MAP.get(id);
                sakuradroprender.renderScreen(1.0F, 1.0F, 1.0F, 1.0F);
            }
        }
    }
}