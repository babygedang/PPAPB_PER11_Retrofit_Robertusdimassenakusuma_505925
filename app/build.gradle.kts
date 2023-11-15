plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.api"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.api"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildFeatures{
        viewBinding = true
    }
    buildFeatures{
        viewBinding = true
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
}

dependencies {
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.6.2")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.1")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    // Retrofit library untuk membuat permintaan HTTP
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson converter untuk Retrofit agar dapat menangani serialisasi dan deserialisasi data JSON
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    // Picasso2 library untuk memuat dan menyimpan gambar
    implementation("com.jakewharton.picasso:picasso2-okhttp3-downloader:1.1.0")
    // Picasso library untuk memuat dan menyimpan gambar
    implementation("com.squareup.picasso:picasso:2.8")

}