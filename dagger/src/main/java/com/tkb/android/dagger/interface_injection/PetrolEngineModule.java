package com.tkb.android.dagger.interface_injection;

import dagger.Module;
import dagger.Provides;

/**
 * Following implementation is one of the styles of Bind Interface with class
 * another style is implemented in DieselEntineModule.
 * And we have to add this module in CarIComponent module list, only one Module of the interface
 * (PetrolEngineModule/DieselEngineModule) will be bind there , otherwise CarIComponent will throw a error, because
 * it has no instruction which EngineModule have to use
 */
@Module
public class PetrolEngineModule {

    @Provides
    public EngineI PetrolEngineModule (PetrolEngine engine){
        return engine;
    }
}
