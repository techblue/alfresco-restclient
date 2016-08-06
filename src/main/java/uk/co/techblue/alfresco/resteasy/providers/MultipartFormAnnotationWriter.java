/*******************************************************************************
 * Copyright 2012 Technology Blueprint Ltd
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package uk.co.techblue.alfresco.resteasy.providers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.AccessController;

import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.FieldEnablerPrivilegedAction;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;
import org.jboss.resteasy.spi.WriterException;
import org.jboss.resteasy.util.FindAnnotation;

/**
 * The Class MultipartFormAnnotationWriter.
 */
@Provider
@Produces("multipart/form-data")
public class MultipartFormAnnotationWriter extends AbstractMultipartFormDataWriter implements MessageBodyWriter<Object>
{

    /*
     * @see javax.ws.rs.ext.MessageBodyWriter#isWriteable(java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType)
     */
    @Override
    public boolean isWriteable(final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType)
    {
        return FindAnnotation.findAnnotation(annotations, MultipartForm.class) != null || type.isAnnotationPresent(MultipartForm.class);
    }

    /*
     * @see javax.ws.rs.ext.MessageBodyWriter#getSize(java.lang.Object, java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType)
     */
    @Override
    public long getSize(final Object o, final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType)
    {
        return -1;
    }

    /*
     * @see javax.ws.rs.ext.MessageBodyWriter#writeTo(java.lang.Object, java.lang.Class, java.lang.reflect.Type,
     * java.lang.annotation.Annotation[], javax.ws.rs.core.MediaType, javax.ws.rs.core.MultivaluedMap, java.io.OutputStream)
     */
    @Override
    public void writeTo(final Object obj, final Class<?> type, final Type genericType, final Annotation[] annotations, final MediaType mediaType,
        final MultivaluedMap<String, Object> httpHeaders, final OutputStream entityStream) throws IOException
    {
        final MultipartFormDataOutput multipart = new MultipartFormDataOutput();

        Class<?> theType = type;
        while (theType != null && !theType.equals(Object.class))
        {
            getFields(theType, multipart, obj);
            theType = theType.getSuperclass();
        }

        for (final Method method : type.getMethods())
        {
            if (method.isAnnotationPresent(FormParam.class) && method.getName().startsWith("get") && method.getParameterTypes().length == 0
                && method.isAnnotationPresent(PartType.class))
            {
                final FormParam param = method.getAnnotation(FormParam.class);
                Object value = null;
                try
                {
                    value = method.invoke(obj);
                } catch (final IllegalAccessException e)
                {
                    throw new WriterException(e);
                } catch (final InvocationTargetException e)
                {
                    throw new WriterException(e.getCause());
                }
                final PartType partType = method.getAnnotation(PartType.class);

                multipart.addFormData(param.value(), value, method.getReturnType(), method.getGenericReturnType(), MediaType.valueOf(partType.value()));
            }
        }

        write(multipart, mediaType, httpHeaders, entityStream);

    }

    /**
     * Gets the fields.
     * 
     * @param type the type
     * @param output the output
     * @param obj the obj
     * @return the fields
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void getFields(final Class<?> type, final MultipartFormDataOutput output, final Object obj)
        throws IOException
    {
        for (final Field field : type.getDeclaredFields())
        {
            if (field.isAnnotationPresent(FormParam.class) && field.isAnnotationPresent(PartType.class))
            {
                AccessController.doPrivileged(new FieldEnablerPrivilegedAction(field));
                final FormParam param = field.getAnnotation(FormParam.class);
                Object value = null;
                try
                {
                    value = field.get(obj);
                } catch (final IllegalAccessException e)
                {
                    throw new WriterException(e);
                }
                final PartType partType = field.getAnnotation(PartType.class);

                output.addFormData(param.value(), value, field.getType(), field.getGenericType(), MediaType.valueOf(partType.value()));
            }
        }
    }

}
