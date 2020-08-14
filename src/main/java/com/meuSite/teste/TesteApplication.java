package com.meuSite.teste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;
import java.util.Locale;

@SpringBootApplication
public class TesteApplication {

	public static void main(String[] args) {

		SpringApplication.run(TesteApplication.class, args);
	}

		@Bean
		public LocaleResolver localeResolver() {
	        return new FixedLocaleResolver(new Locale("pt", "BR"));
		}
	}

