// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.kotlin.android) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.jetbrains.kotlin.jvm) apply false
  alias(libs.plugins.android.library) apply false
  alias(libs.plugins.spotless) apply false
  alias(libs.plugins.apollo) apply false
  alias(libs.plugins.sqldelight) apply false
}

subprojects {
  apply(plugin = "com.diffplug.spotless")
  configure<com.diffplug.gradle.spotless.SpotlessExtension> {
    kotlin {
      target("src/**/*.kt")
      ktlint(
        libs.ktlint.cli
          .get()
          .version,
      ).editorConfigOverride(
        mapOf(
          "ktlint_standard_function-expression-body" to "disabled",
          "ktlint_standard_filename" to "disabled",
          "ktlint_standard_function-naming" to "disabled",
          "ktlint_function_naming_ignore_when_annotated_with" to "Composable",
        ),
      ).customRuleSets(
        listOf(
          libs.ktlint.compose.rules
            .get()
            .toString(),
        ),
      )
    }

    kotlinGradle {
      target("*.kts")
      ktlint(
        libs.ktlint.cli
          .get()
          .version,
      )
    }
  }
}
