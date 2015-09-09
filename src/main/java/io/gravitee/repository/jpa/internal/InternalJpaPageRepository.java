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
package io.gravitee.repository.jpa.internal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.gravitee.repository.jpa.model.PageJpa;

/**
 * @author Azize Elamrani (azize dot elamrani at gmail dot com)
 */
public interface InternalJpaPageRepository extends JpaRepository<PageJpa, String> {

    List<PageJpa> findByApiName(String apiName);

    @Query("select max(p.order) from PageJpa p where p.apiName = ?1")
    int findMaxOrderByApiName(String apiName);
}