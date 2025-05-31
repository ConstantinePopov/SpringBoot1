package config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springBootDemo.*;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(
            value = "netology.profile.dev",
            havingValue = "true"
    )
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(
            value = "netology.profile.dev",
            havingValue = "false",
            matchIfMissing = true
    )
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
