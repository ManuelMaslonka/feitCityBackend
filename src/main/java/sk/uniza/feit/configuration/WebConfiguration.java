package sk.uniza.feit.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Value("${application.image.base-url}")
    private String imageBaseUrl;

    @Value("${application.url.api-url}")
    private String apiUrl;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(apiUrl + imageBaseUrl + "**")
                .addResourceLocations("file:src/main/resources/static/images/");

    }
}
