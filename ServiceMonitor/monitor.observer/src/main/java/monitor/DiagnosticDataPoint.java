/*
 *
 *  * Copyright 2019 Google LLC.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 *
 */

package monitor.observer;

import java.time.ZonedDateTime;
import java.util.Objects;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

public final class DiagnosticDataPoint {

  private final String service;
  private final ZonedDateTime timestamp;
  private final boolean alive;

  private DiagnosticDataPoint(String service, ZonedDateTime timestamp, boolean alive) {
    this.service = requireNonNull(service);
    this.timestamp = requireNonNull(timestamp);
    this.alive = alive;
  }

  public static DiagnosticDataPoint of(String service, ZonedDateTime timestamp, boolean alive) {
    return new DiagnosticDataPoint(service, timestamp, alive);
  }

  public String service() {
    return service;
  }

  public ZonedDateTime timestamp() {
    return timestamp;
  }

  public boolean alive() {
    return alive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DiagnosticDataPoint that = (DiagnosticDataPoint) o;
    return alive == that.alive
        && Objects.equals(service, that.service)
        && Objects.equals(timestamp, that.timestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(service, timestamp, alive);
  }

  @Override
  public String toString() {
    return format("DiagnosticDataPoint{%s / %s: alive=%s}", service, timestamp, alive);
  }
}
