//package com.nali.sd.mixin;
//
//import com.nali.sd.SD;
//import com.nali.sd.entities.EntitiesRenderHelper;
//import com.nali.sd.entities.data.gui.SakuraDrop;
//import net.minecraft.client.gui.GuiScreen;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Mixin(GuiScreen.class)
//public abstract class MixinGuiScreen
//{
//    @Shadow public int width;
//    @Shadow public int height;
//
////    @Inject(method = "mouseClicked", at = @At("HEAD"))
////    private static void mouseClicked(int mouseX, int mouseY, int mouseButton, CallbackInfo ci)
////    {
////    }
//
//    @Inject(method = "mouseReleased", at = @At("HEAD"))
//    private void mouseReleased(int mouseX, int mouseY, int mouseButton, CallbackInfo ci)
//    {
//        SakuraDrop sakuradrop = new SakuraDrop(EntitiesRenderHelper.DATALOADER);
//        sakuradrop.x = mouseX;
//        sakuradrop.y = mouseY;
//    }
//
//    @Inject(method = "drawScreen", at = @At("TAIL"))
//    private void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci)
//    {
//        if (!SakuraDrop.SAKURADROP_MAP.isEmpty())
//        {
//            Set<Integer> keys_set = new HashSet<>(SakuraDrop.SAKURADROP_MAP.keySet());
//            for (Integer id : keys_set)
//            {
//                SakuraDrop.SAKURADROP_MAP.get(id).render(this.width, this.height);
//            }
//        }
//    }
//}
