/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.repository.jpa.converter;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.net.URI;

import org.springframework.stereotype.Component;

import io.gravitee.repository.jpa.model.ApiJpa;
import io.gravitee.repository.model.management.Api;

/**
 * @author Azize Elamrani (azize dot elamrani at gmail dot com)
 */
@Component
public class ApiJpaConverter extends AbstractConverter<ApiJpa, Api> {

    public Api convertTo(final ApiJpa apiJpa) {
        if (apiJpa == null) {
            return null;
        }
        final Api api = new Api();
        copyProperties(apiJpa, api);
        final String publicURI = apiJpa.getPublicURI();
        if (publicURI != null) {
            api.setPublicURI(URI.create(publicURI));
        }
        final String targetURI = apiJpa.getTargetURI();
        if (targetURI != null) {
            api.setTargetURI(URI.create(targetURI));
        }
        return api;
    }

    public ApiJpa convertFrom(final Api api) {
        if (api == null) {
            return null;
        }
        final ApiJpa apiJpa = new ApiJpa();
        copyProperties(api, apiJpa);
        final URI publicURI = api.getPublicURI();
        if (publicURI != null) {
            apiJpa.setPublicURI(publicURI.toString());
        }
        final URI targetURI = api.getTargetURI();
        if (targetURI != null) {
            apiJpa.setTargetURI(targetURI.toString());
        }
        return apiJpa;
    }
}
