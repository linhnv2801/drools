/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kie.runtime;

public class EnvironmentName {
    public static final String TRANSACTION_MANAGER                  = "org.kie.transaction.TransactionManager";
    public static final String TRANSACTION_SYNCHRONIZATION_REGISTRY = "org.kie.transaction.TransactionSynchronizationRegistry";
    public static final String TRANSACTION                          = "org.kie.transaction.Transaction";

    public static final String ENTITY_MANAGER_FACTORY               = "org.kie.persistence.jpa.EntityManagerFactory";
    public static final String CMD_SCOPED_ENTITY_MANAGER            = "org.kie.persistence.jpa.CmdScopedEntityManager";
    public static final String APP_SCOPED_ENTITY_MANAGER            = "org.kie.persistence.jpa.AppScopedEntityManager";
    public static final String PERSISTENCE_CONTEXT_MANAGER          = "org.kie.persistence.PersistenceContextManager";

    public static final String OBJECT_MARSHALLING_STRATEGIES        = "org.kie.marshalling.ObjectMarshallingStrategies";
    public static final String GLOBALS                              = "org.kie.Globals";
    public static final String CALENDARS                            = "org.kie.time.Calendars";
    public static final String DATE_FORMATS                         = "org.kie.build.DateFormats";
}
