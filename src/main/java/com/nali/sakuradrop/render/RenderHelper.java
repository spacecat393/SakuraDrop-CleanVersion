package com.nali.sakuradrop.render;

import com.nali.sakuradrop.system.Reference;
import com.nali.system.opengl.memory.OpenGLTextureMemory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderHelper
{
    public static OpenGLTextureMemory OPENGLTEXTUREMEMORY = new OpenGLTextureMemory(com.nali.system.Reference.MOD_ID + "/" + Reference.MOD_ID + "/");
}
