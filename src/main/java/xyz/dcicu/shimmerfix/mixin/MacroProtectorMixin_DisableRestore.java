package xyz.dcicu.shimmerfix.mixin;

import dev.greencat.shimmer.Shimmer;
import dev.greencat.shimmer.module.Module;
import dev.greencat.shimmer.module.modules.macro.MacroProtector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.dcicu.shimmerfix.access.MacroProtectorAccessor;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Mixin(value = MacroProtector.class, remap = false)
public abstract class MacroProtectorMixin_DisableRestore implements MacroProtectorAccessor {

    @Unique
    private final List<Module> lastDisabledModules = new CopyOnWriteArrayList<>();

    @Inject(method = "disableAllMacro", at = @At("HEAD"), cancellable = true)
    private void onDisableAllMacro(CallbackInfo ci) {
        lastDisabledModules.clear();
        for (Module module : Shimmer.getInstance().getModuleManager().modules) {
            if (module.needDisable && module.isEnabled()) {
                module.setEnabled(false);
                lastDisabledModules.add(module);
            }
        }
        ci.cancel();
    }

    @Unique
    @Override
    public void restoreDisabledMacros() {
        for (Module module : lastDisabledModules) {
            if (!module.isEnabled()) {
                module.setEnabled(true);
            }
        }
        lastDisabledModules.clear();
    }
}