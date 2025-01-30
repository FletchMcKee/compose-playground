plugins {
  alias(libs.plugins.android.library)
  alias(libs.plugins.kotlin.android)
  alias(libs.plugins.apollo)
  alias(libs.plugins.sqldelight)
}

android {
  namespace = "com.fletchmckee.composeplayground.data"
  compileSdk =
    libs.versions.compileSdk
      .get()
      .toInt()

  defaultConfig {
    minSdk =
      libs.versions.minSdk
        .get()
        .toInt()
  }

  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }

  kotlinOptions {
    jvmTarget = "11"
  }

  @Suppress("UnstableApiUsage")
  testOptions {
    targetSdk =
      libs.versions.compileSdk
        .get()
        .toInt()
  }
}

dependencies {
  api(libs.kotlinx.datetime)
  implementation(libs.apollo.runtime)
  implementation(libs.apollo.normalized.cache)
  implementation(libs.sqldelight.android)
  implementation(project(":common:util"))
  testImplementation(libs.sqldelight.sqlite)
}

apollo {
  service("Service") {
    packageName.set("com.fletchmckee.composeplayground.data")
    srcDir("src/main/graphql")
    includes.add("*/**/*.graphql")

    introspection {
      endpointUrl.set("https://connect.squareupsandbox.com/public/graphql")
      schemaFile.set(file("src/main/graphql/schema.graphqls"))
    }
  }
}

sqldelight {
  databases {
    create("Database") {
      packageName.set("com.fletchmckee.composeplayground.data")
    }
  }
}
