architectury {
    common("neoforge", "fabric")
}

dependencies {
    compileOnly(libs.mixin)
    compileOnly(libs.mixinextras)

    implementation(libs.geyser.api) // ✅ Changed from compileOnly
    compileOnly(libs.geyser.core) {
        exclude(group = "io.netty")
        exclude(group = "io.netty.incubator")
    }

    api(libs.pack.converter)

    implementation(libs.auto.service)
    annotationProcessor(libs.auto.service)

    // Only here to suppress "unknown enum constant EnvType.CLIENT" warnings.
    compileOnly(libs.fabric.loader)
}