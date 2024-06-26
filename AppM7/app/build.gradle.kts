import com.android.tools.r8.internal.im
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {

    namespace = "com.example.appm7"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.appm7"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    signingConfigs {
        create("Anthony") {
            keyAlias = "anthony"
            keyPassword = "anthony"
            storeFile = file("C:/Users/Sebastian/Documents/DAM/M7/Verconnect/DAM2_M7/AppM7/my-release-key.jks")
            storePassword = "anthony"
        }
    }
}

dependencies {
    implementation("androidx.fragment:fragment:1.6.2")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")
    //implementation ("com.android.support:design:28.0.0")  // Para Snackbar
    implementation ("com.google.android.material:material:1.4.0")  // Para Snackbar y Material Design
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation ("com.google.code.gson:gson:2.8.6")
}