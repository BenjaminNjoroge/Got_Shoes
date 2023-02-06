package com.webnetworksolution.gotshoes

import android.app.Application
import android.content.Context
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import com.webnetworksolution.gotshoes.R

class GotShoes: Application() {

    override fun onCreate() {
        super.onCreate()
        ViewPump.init(ViewPump.builder().addInterceptor(
            CalligraphyInterceptor(
                CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/Montserrat-Regular.ttf")
                    .setFontAttrId(io.github.inflationx.calligraphy3.R.attr.fontPath)
                    .build())
        ).build())
    }

    //wrap the activity context
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(base))
    }
}