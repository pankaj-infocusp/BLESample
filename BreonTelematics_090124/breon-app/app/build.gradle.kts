import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.kotlinKapt)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.sentry)
    alias(libs.plugins.googlePlayService)
    alias(libs.plugins.crashlytics)
}

android {
    namespace = "breon.telematics.loneworkersafetyapp.android"
    compileSdk = 34

    defaultConfig {
        applicationId = "breon.telematics.loneworkersafetyapp.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 17
        versionName = "1.45"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
//        buildConfigField("String", "BASE_URL", "\"http://49.13.17.113:8087/\"")
//        buildConfigField("String", "BASE_URL", "\"http://20.211.43.248:8081/\"")
//        buildConfigField("String", "BASE_URL", "\"http://prod-breont-mobileapis.australiaeast.cloudapp.azure.com:81/\"")
//        buildConfigField("String", "ASSET_BASE_URL", "\"https://prod23-am.azurewebsites.net/\"")
//          buildConfigField("String", "BASE_URL", "\"https://mobileapi-prod-agejc2h6g2f9e0en.australiaeast-01.azurewebsites.net/\"")
          buildConfigField("String", "BASE_URL", "\"https://assetmonitoring-webapp-dev.azurewebsites.net/\"")
          buildConfigField("String", "BASE_URL_DEV", "\"https://mobileapi-dev-bbgtajfmhpd6hbdq.australiaeast-01.azurewebsites.net/\"")
          buildConfigField("String", "API_KEY", "\"666105e6-33de-4856-b343-7634a0599679\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        applicationVariants.all {
            outputs.map {
                it as com.android.build.gradle.internal.api.ApkVariantOutputImpl
            }.all { output ->
                val date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
                val apkFileName = "BreonApp-${date}.apk"
                output.outputFileName = apkFileName
                false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"

    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }
    //android.buildFeatures.buildConfig = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activityKtx)
    implementation(libs.androidx.constraintlayout)

    //AndroidX
    implementation(libs.androidx.activity)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.viewPager2)
    implementation(libs.firebase.messaging.ktx)

    //Test Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // sdp and ssp for font
    implementation(libs.sdp.dimens)
    implementation(libs.ssp.dimens)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.gsonConvertor)
    implementation(libs.scalarsConvertor)
    implementation(libs.okHttp)
    implementation(libs.okHttp.logging.intercepter)

    // room
    implementation(libs.roomRuntime)
    implementation(libs.roomRuntimeKtx)

    // coroutine
    implementation(libs.coroutineAndroid)
    implementation(libs.coroutineKotlin)

    //Coil
    implementation(libs.coil)

    //Browser
    implementation(libs.browser)

    //Dagger Hilt
    implementation(libs.dagger.hilt)
    kapt(libs.hilt.compiler)

    //Location Provider
    implementation(libs.location)

    //Event Bus
    implementation(libs.event.bus)

    //Firebase BOM
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.messaging.ktx)
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

}



