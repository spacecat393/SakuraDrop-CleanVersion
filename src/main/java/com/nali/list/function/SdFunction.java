package com.nali.list.function;

import com.nali.sd.key.KeyTick;

import static com.nali.sd.key.KeyTick.mainRun;

public class SdFunction
{
    public SdFunction()
    {
        KeyTick.FUNCTION = v -> mainRun();
    }
}
