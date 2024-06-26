/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0; you may not use this file except in compliance with the Elastic License
 * 2.0.
 */

package org.elasticsearch.xpack.deprecation;

import org.elasticsearch.action.support.nodes.BaseNodesRequest;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.core.UpdateForV9;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class NodesDeprecationCheckRequest extends BaseNodesRequest<NodesDeprecationCheckRequest> {

    @UpdateForV9 // this constructor is unused in v9
    public NodesDeprecationCheckRequest(StreamInput in) throws IOException {
        super(in);
    }

    public NodesDeprecationCheckRequest(String... nodesIds) {
        super(nodesIds);
    }

    @UpdateForV9 // this method can just call localOnly() in v9
    @Override
    public void writeTo(StreamOutput out) throws IOException {
        super.writeTo(out);
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object[]) this.nodesIds());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NodesDeprecationCheckRequest that = (NodesDeprecationCheckRequest) obj;
        return Arrays.equals(this.nodesIds(), that.nodesIds());
    }
}
