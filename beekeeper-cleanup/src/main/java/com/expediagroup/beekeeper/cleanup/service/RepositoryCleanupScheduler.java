/**
 * Copyright (C) 2019-2021 Expedia, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expediagroup.beekeeper.cleanup.service;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RepositoryCleanupScheduler {

  private static final Logger log = LoggerFactory.getLogger(RepositoryCleanupScheduler.class);

  private final RepositoryCleanupService cleanupService;

  @Autowired
  public RepositoryCleanupScheduler(RepositoryCleanupService cleanupService) {
    this.cleanupService = cleanupService;
  }

  @Scheduled(cron = "")
  public void oldRecordsCleanupWithCron() {
    Instant now = Instant.now();
    log.info("Started cleanup");
    cleanupService.cleanUp(now);
    log.info("Finished cleanup");
  }
}
