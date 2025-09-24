pluginManagement {
    val flutterSdkPath =
        run {
            val properties = java.util.Properties()
            file("local.properties").inputStream().use { properties.load(it) }
            val flutterSdkPath = properties.getProperty("flutter.sdk")
            require(flutterSdkPath != null) { "flutter.sdk not set in local.properties" }
            flutterSdkPath
        }

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("dev.flutter.flutter-plugin-loader") version "1.0.0"
    id("com.android.application") version "8.9.1" apply false
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false
}

include(":app")


/*pluginManagement {
    def flutterSdkPath = {
        def properties = new Properties()
        file("local.properties").withInputStream { properties.load(it) }
        def flutterSdkPath = properties.getProperty("flutter.sdk")
        assert flutterSdkPath != null, "flutter.sdk not set in local.properties"
        return flutterSdkPath
    }()

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id "dev.flutter.flutter-plugin-loader" version "1.0.0"
    id "com.android.application" version "{agpVersion}" apply false
    id "org.jetbrains.kotlin.android" version "{kotlinVersion}" apply false
    id "com.google.gms.google-services" version "4.4.0" apply false
    id "com.google.firebase.crashlytics" version "2.9.9" apply false
}
include ":app"*/



// settings.gradle.kts

// settings.gradle.kts

// android/settings.gradle.kts

/*pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    // 🔁 Ceci est ESSENTIEL pour que Flutter fonctionne
    val flutterSdkPath = run {
        val properties = java.util.Properties()
        file("local.properties").inputStream().use { properties.load(it) }
        val path = properties.getProperty("flutter.sdk")
        requireNotNull(path) { "flutter.sdk not set in local.properties" }
    }

    // ✅ C'est ce includeBuild qui rend le plugin "flutter-plugin-loader" disponible
    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")
}

include(":app")

// 🔁 Charger les plugins Flutter dynamiquement
val flutterPluginsFile = File(rootDir.parentFile, ".flutter-plugins")
if (flutterPluginsFile.exists()) {
    val plugins = java.util.Properties()
    flutterPluginsFile.inputStream().use { plugins.load(it) }

    plugins.forEach { name, path ->
        val pluginDir = File(rootDir.parentFile, "$path/android")
        include(":$name")
        project(":$name").projectDir = pluginDir
    }
}*/
