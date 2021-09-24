/*-
 * #%L
 * Coffee
 * %%
 * Copyright (C) 2020 i-Cell Mobilsoft Zrt.
 * %%
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
 * #L%
 */
package hu.icellmobilsoft.coffee.module.mp.opentracing.extension;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import hu.icellmobilsoft.coffee.cdi.trace.annotation.Traced;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;

/**
 * Default interceptor for {@link Traced} binding
 * 
 * @author czenczl
 * @since 1.3.0
 */
@Traced
@Interceptor
@Priority(value = Interceptor.Priority.APPLICATION)
public class OpenTraceInterceptor extends BaseOpenTraceInterceptor {

    /**
     * Intercept and handle span creation with called method name
     * 
     * @param ctx
     *            {@link InvocationContext} context
     * @return InvocationContext {@link InvocationContext#proceed()}
     * @throws Exception
     *             if error
     */
    @AroundInvoke
    public Object wrap(InvocationContext ctx) throws Exception {

        Tracer tracer = getTracer();

        String methodName = ctx.getMethod().getName();
        Tracer.SpanBuilder spanBuilder = tracer.buildSpan(methodName);
        spanBuilder.withTag(Tags.COMPONENT.getKey(), "default");
        spanBuilder.withTag(Tags.SPAN_KIND.getKey(), Tags.COMPONENT.getKey());

        return handleSpan(ctx, spanBuilder);

    }

}
