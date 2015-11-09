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
package io.gravitee.repository.jdbc.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Azize Elamrani (azize dot elamrani at gmail dot com)
 */
@Entity
@Table(name = "GRAVITEE_NODE")
public class NodeJpa {

	@Id
    private String name;
    private String host;
    private String cluster;
    
    /**
     * Current node state
     */
    private String state;
    
    /**
     * The last node start date
     */
    private Date lastStartupTime;
    
    /**
     * The last node stop date
     */
    private Date lastStopTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

	public Date getLastStartupTime() {
		return lastStartupTime;
	}

	public void setLastStartupTime(Date lastStartupTime) {
		this.lastStartupTime = lastStartupTime;
	}

	public Date getLastStopTime() {
		return lastStopTime;
	}

	public void setLastStopTime(Date lastStopTime) {
		this.lastStopTime = lastStopTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NodeJpa)) {
            return false;
        }
        NodeJpa nodeJpa = (NodeJpa) o;
        return Objects.equals(name, nodeJpa.name);
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return "NodeJpa{" +
            "name='" + name + '\'' +
            ", host='" + host + '\'' +
            ", cluster='" + cluster + '\'' +
            ", state='" + state + '\'' +
            ", lastStartupTime=" + lastStartupTime +
            ", lastStopTime=" + lastStopTime +
            '}';
    }
}
