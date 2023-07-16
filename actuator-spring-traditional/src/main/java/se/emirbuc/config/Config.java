package se.emirbuc.config;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.HealthIndicatorAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricExportAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricFilterAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricRepositoryAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricsChannelAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.MetricsDropwizardAutoConfiguration;
import org.springframework.boot.actuate.autoconfigure.PublicMetricsAutoConfiguration;
import org.springframework.boot.actuate.endpoint.BeansEndpoint;
import org.springframework.boot.actuate.endpoint.ConfigurationPropertiesReportEndpoint;
import org.springframework.boot.actuate.endpoint.DumpEndpoint;
import org.springframework.boot.actuate.endpoint.EnvironmentEndpoint;
import org.springframework.boot.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.actuate.endpoint.InfoEndpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.boot.actuate.endpoint.RequestMappingEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.EndpointHandlerMapping;
import org.springframework.boot.actuate.endpoint.mvc.EndpointMvcAdapter;
import org.springframework.boot.actuate.endpoint.mvc.EnvironmentMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.HealthMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MetricsMvcEndpoint;
import org.springframework.boot.actuate.endpoint.mvc.MvcEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * The <code>Class Config</code>.
 *
 * @author Emir Bucalovic (embuc)
 * @since 2015-dec-08
 */
@Configuration
@Import({ EndpointAutoConfiguration.class, HealthIndicatorAutoConfiguration.class, MetricExportAutoConfiguration.class,
		MetricFilterAutoConfiguration.class, MetricsChannelAutoConfiguration.class, MetricsDropwizardAutoConfiguration.class,
		MetricRepositoryAutoConfiguration.class, PublicMetricsAutoConfiguration.class })
@SuppressWarnings("javadoc")
public class Config {

	@Bean
	@Autowired
	public EndpointHandlerMapping endpointHandlerMapping(Collection<? extends MvcEndpoint> endpoints) {
		return new EndpointHandlerMapping(endpoints);
	}

	@Bean
	@Autowired
	public HealthMvcEndpoint healthMvcEndpoint(HealthEndpoint delegate) {
		return new HealthMvcEndpoint(delegate, false);
	}

	@Bean
	@Autowired
	public MetricsMvcEndpoint metricsMvcEndpoint(MetricsEndpoint delegate) {
		return new MetricsMvcEndpoint(delegate);
	}

	@Bean
	@Autowired
	public EnvironmentMvcEndpoint environmentMvcEndpoint(EnvironmentEndpoint delegate) {
		return new EnvironmentMvcEndpoint(delegate);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter infoMvcEndPoint(InfoEndpoint delegate) {
		return new EndpointMvcAdapter(delegate);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter beansEndPoint(BeansEndpoint delegate) {
		return new EndpointMvcAdapter(delegate);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter dumpEndPoint(DumpEndpoint delegate) {
		return new EndpointMvcAdapter(delegate);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter configurationPropertiesEndPoint(ConfigurationPropertiesReportEndpoint delegate) {
		return new EndpointMvcAdapter(delegate);
	}

	@Bean
	@Autowired
	public EndpointMvcAdapter requestMappingEndPoint(RequestMappingEndpoint delegate) {
		return new EndpointMvcAdapter(delegate);
	}
}