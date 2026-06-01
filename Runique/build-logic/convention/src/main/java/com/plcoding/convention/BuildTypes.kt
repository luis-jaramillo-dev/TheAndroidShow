package com.plcoding.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DynamicFeatureExtension
import com.android.build.api.dsl.LibraryExtension
import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import java.io.File
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension,
    extensionType: ExtensionType
) {
    commonExtension.buildFeatures.apply { buildConfig = true }

    val apiKey = gradleLocalProperties(rootDir, rootProject.providers).getProperty("API_KEY")
    when(extensionType) {
        ExtensionType.APPLICATION -> {
            this@configureBuildTypes.extensions.configure<ApplicationExtension> {
                buildTypes {
                    debug {
                        configureDebugBuildType(apiKey)
                    }
                    release {
                        configureReleaseBuildType(
                            defaultProguardFile = getDefaultProguardFile("proguard-android-optimize.txt"),
                            apiKey = apiKey
                        )
                    }
                }
            }
        }
        ExtensionType.LIBRARY -> {
            this@configureBuildTypes.extensions.configure<LibraryExtension> {
                buildTypes {
                    debug {
                        configureDebugBuildType(apiKey)
                    }
                    release {
                        configureReleaseBuildType(
                            defaultProguardFile = getDefaultProguardFile("proguard-android-optimize.txt"),
                            apiKey = apiKey
                        )
                    }
                }
            }
        }
        ExtensionType.DYNAMIC_FEATURE -> {
            this@configureBuildTypes.extensions.configure<DynamicFeatureExtension> {
                buildTypes {
                    debug {
                        configureDebugBuildType(apiKey)
                    }
                    release {
                        configureReleaseBuildType(
                            defaultProguardFile = getDefaultProguardFile("proguard-android-optimize.txt"),
                            apiKey = apiKey
                        )
                        isMinifyEnabled = false
                    }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuildType(apiKey: String) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"https://runique.pl-coding.com:8080\"")
}

private fun BuildType.configureReleaseBuildType(
    defaultProguardFile: File,
    apiKey: String,
) {
    buildConfigField("String", "API_KEY", "\"$apiKey\"")
    buildConfigField("String", "BASE_URL", "\"https://runique.pl-coding.com:8080\"")

    isMinifyEnabled = true
    proguardFiles(
        defaultProguardFile,
        "proguard-rules.pro"
    )
}