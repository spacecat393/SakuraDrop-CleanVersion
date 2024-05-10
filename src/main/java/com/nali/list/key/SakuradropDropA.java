package com.nali.list.key;

import com.nali.key.MixKeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.sakuradrop.key.KeyTick.render;

@SideOnly(Side.CLIENT)
public class SakuradropDropA extends MixKeyBinding
{
    public static int ID;
    public SakuradropDropA(String[] string_array, Integer key)
    {
        super(string_array, key == null ? -100 : key);
    }

    public static void detect()
    {
        render(Minecraft.getMinecraft());
    }
}
