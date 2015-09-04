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
package io.gravitee.repository.jpa.model;

import java.net.URI;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.gravitee.repository.model.LifecycleState;
import io.gravitee.repository.model.OwnerType;

/**
 * @author Azize Elamrani (azize dot elamrani at gmail dot com)
 */
@Entity
@Table(name = "API")
public class ApiJpa {

    @Id
    private String name;

    private String description;

    private String version;

    private URI publicURI;
    
    private URI targetURI;

    private Date createdAt;
    
    private Date updatedAt;
    
    private OwnerType ownerType;
    
    private String owner;

    private String creator;

    private boolean privateApi;

    private LifecycleState lifecycleState = LifecycleState.STOPPED;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LifecycleState getLifecycleState() {
        return lifecycleState;
    }

    public void setLifecycleState(LifecycleState lifecycleState) {
        this.lifecycleState = lifecycleState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URI getPublicURI() {
        return publicURI;
    }

    public void setPublicURI(URI publicURI) {
        this.publicURI = publicURI;
    }

    public URI getTargetURI() {
        return targetURI;
    }

    public void setTargetURI(URI targetURI) {
        this.targetURI = targetURI;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isPrivate() {
        return privateApi;
    }

    public void setPrivate(boolean privateApi) {
        this.privateApi = privateApi;
    }
    
    public OwnerType getOwnerType() {
		return ownerType;
	}

	public void setOwnerType(OwnerType ownerType) {
		this.ownerType = ownerType;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiJpa api = (ApiJpa) o;
        return Objects.equals(name, api.name) &&
                Objects.equals(version, api.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version);
    }

    public String toString() {
        return "Api{" +
            "name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", version='" + version + '\'' +
            ", publicURI=" + publicURI +
            ", targetURI=" + targetURI +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", ownerType=" + ownerType +
            ", owner='" + owner + '\'' +
            ", creator='" + creator + '\'' +
            ", privateApi=" + privateApi +
            ", lifecycleState=" + lifecycleState +
            '}';
    }
}
