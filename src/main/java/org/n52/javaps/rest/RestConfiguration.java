/*
 * Copyright (C) 2016 by 52 North Initiative for Geospatial Open Source Software GmbH
 *
 * Contact: Andreas Wytzisk
 * 52 North Initiative for Geospatial Open Source Software GmbH
 * Martin-Luther-King-Weg 24
 * 48155 Muenster, Germany
 * info@52north.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.javaps.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import java.util.Properties;

@Configuration
public class RestConfiguration {

    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ContentNegotiationManagerFactoryBean cnManager() {
        ContentNegotiationManagerFactoryBean cnManager = new ContentNegotiationManagerFactoryBean();
        cnManager.setFavorPathExtension(true);
        cnManager.setDefaultContentType(MediaType.TEXT_HTML);
        Properties mapping = new Properties();
        mapping.setProperty("html", MediaTypes.TEXT_HTML);
        mapping.setProperty("json", MediaTypes.APPLICATION_JSON);
        mapping.setProperty("xml", MediaTypes.APPLICATION_XML);
        mapping.setProperty("js", MediaTypes.APPLICATION_JAVASCRIPT);
        cnManager.setMediaTypes(mapping);
        return cnManager;
    }

}