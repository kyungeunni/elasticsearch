/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License
 * 2.0 and the Server Side Public License, v 1; you may not use this file except
 * in compliance with, at your election, the Elastic License 2.0 or the Server
 * Side Public License, v 1.
 */

package org.elasticsearch.action.bulk;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.test.ESTestCase;

public class BulkRequestBuilderTests extends ESTestCase {

    public void testValidation() {
        BulkRequestBuilder bulkRequestBuilder = new BulkRequestBuilder(null, null);
        bulkRequestBuilder.add(new IndexRequestBuilder(null, randomAlphaOfLength(10)));
        bulkRequestBuilder.add(new IndexRequest());
        expectThrows(IllegalStateException.class, bulkRequestBuilder::request);
    }
}
