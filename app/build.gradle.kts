plugins {
    kotlin("android")
    id("com.android.application")
    id("kotlin-kapt")
}

android {
    namespace = "com.begoml.androidconcurrency"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.begoml.androidconcurrency"
        minSdk = 28
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    lint.abortOnError = false
}

dependencies {

    implementation("androidx.activity:activity-compose:1.6.1")

    implementation(platform("androidx.compose:compose-bom:2022.10.00"))

    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.ui:ui")

    implementation("com.google.dagger:dagger:2.43.2")
    kapt("com.google.dagger:dagger-compiler:2.43.2")

    implementation("androidx.navigation:navigation-compose:2.5.3")
}
