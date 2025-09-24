allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

val newBuildDir: Directory =
    rootProject.layout.buildDirectory
        .dir("../../build")
        .get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}
subprojects {
    project.evaluationDependsOn(":app")
}

tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}


// build.gradle.kts (à la racine du dossier android)

/*allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

// Réorganise les dossiers de build pour tout centraliser dans ../../build
val newBuildDir = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.set(newBuildDir)

subprojects {
    layout.buildDirectory.set(newBuildDir.dir(name))
}

// ⚠️ Éviter evaluationDependsOn si possible (déconseillé avec Kotlin DSL + Gradle 8)
gradle.beforeProject {
    if (it.name != rootProject.name) {
        it.evaluationDependsOn(":app") // À éviter si possible, sinon garde temporairement
    }
}

// Tâche clean
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}
*/