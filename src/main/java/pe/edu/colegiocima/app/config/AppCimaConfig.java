package pe.edu.colegiocima.app.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.MappedInterceptor;
import pe.edu.colegiocima.app.monitor.MetricInterceptor;

@Configuration
public class AppCimaConfig {
    @Bean
    public MappedInterceptor metricInterceptor(MeterRegistry registry){
        return new MappedInterceptor(new String[]{"/**"},new MetricInterceptor(registry));
    }

    @Bean
    MeterRegistryCustomizer<MeterRegistry> metricsCommonsTags() {
        return  registry -> registry.config().commonTags("application","appcimadev");
    }
}
