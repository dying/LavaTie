package com.dabbotorg.lavatie;

import com.dabbotorg.lavatie.commons.rest.RepresentationDeserializer;
import com.dabbotorg.lavatie.commons.rest.RepresentationId;
import com.dabbotorg.lavatie.commons.rest.RepresentationSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.stream.Collectors;

@Component
@Configuration
@Slf4j
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(@Autowired ObjectMapper objectMapper, @Autowired RepresentationSerializer serializer, @Autowired RepresentationDeserializer deserializer) {

        SimpleModule serializers = new SimpleModule();
        serializers.addSerializer(RepresentationId.class, serializer);
        serializers.addDeserializer(RepresentationId.class, deserializer);
        objectMapper.registerModule(serializers);

        property(ServletProperties.FILTER_FORWARD_ON_404, true);

        register("com.dabbotorg.lavatie");

        // This is a custom scanner for Jersey resources
        // There is a bug in Jersey that since Spring Boot 1.4 prevents it from scanning the classpath properly
        // For more info see: 		https://github.com/spring-projects/spring-boot/issues/1468
        // Or: 						https://github.com/jersey/jersey/pull/196
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        this.registerClasses(scanner.findCandidateComponents("com.dabbotorg.lavatie").stream()
            .map(beanDefinition -> ClassUtils.resolveClassName(beanDefinition.getBeanClassName(), this.getClassLoader())).collect(Collectors.toSet()));
    }
}
