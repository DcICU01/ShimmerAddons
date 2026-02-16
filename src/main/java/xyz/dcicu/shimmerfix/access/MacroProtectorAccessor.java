package xyz.dcicu.shimmerfix.access;

import org.spongepowered.asm.mixin.Unique;

public interface MacroProtectorAccessor {

    @Unique
    void restoreDisabledMacros();
}
