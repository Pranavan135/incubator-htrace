/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.htrace;

import java.util.Map;

import org.apache.hadoop.classification.InterfaceAudience;
import org.apache.hadoop.classification.InterfaceStability;

/**
 * The collector within a process that is the destination of Spans when a trace
 * is running.
 */
@InterfaceAudience.Public
@InterfaceStability.Evolving
public interface SpanReceiver {

  /**
   * Called when a Span is stopped and can now be stored.
   * 
   * @param traceId
   * @param spanId
   * @param parentId
   * @param start
   * @param stop
   * @param description
   * @param data
   * @param processId
   */
  public void span(long traceId, long spanId, long parentId, long start,
      long stop,
      String description, Map<String, String> data, String processId);

  /**
   * Called when a trace is finished.
   */
  public void flush();
}