package com.oomori.app.config

import freemarker.template.TemplateModelException
import no.api.freemarker.java8.Java8ObjectWrapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer
import javax.annotation.PostConstruct

@Configuration
class FreemarkerCustomConfig @Autowired
constructor(private val configuration: freemarker.template.Configuration) {
    @PostConstruct
    @Throws(TemplateModelException::class)
    fun postConstruct() {
        configuration.setSharedVariable("ASSET_JS_VER", System.currentTimeMillis())
        configuration.setSharedVariable("ASSET_CSS_VER", System.currentTimeMillis())
        configuration.numberFormat = "computer"
        configuration.isAPIBuiltinEnabled = true
        configuration.recognizeStandardFileExtensions = true
        configuration.objectWrapper = Java8ObjectWrapper(freemarker.template.Configuration.getVersion())
    }
}