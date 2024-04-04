package com.nali.list.function;

import com.nali.sakuradrop.key.KeyTick;

import static com.nali.sakuradrop.key.KeyTick.mainRun;

public class SdFunction
{
    public SdFunction()
    {
        KeyTick.FUNCTION = v -> mainRun();
    }
}
