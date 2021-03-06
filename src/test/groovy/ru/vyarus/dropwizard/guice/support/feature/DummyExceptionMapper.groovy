package ru.vyarus.dropwizard.guice.support.feature

import com.sun.jersey.api.client.ClientResponse
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

/**
 * http://avianey.blogspot.ru/2011/12/exception-mapping-jersey.html.
 * @author Vyacheslav Rusakov 
 * @since 03.09.2014
 */
@Provider
@javax.inject.Singleton
class DummyExceptionMapper implements ExceptionMapper<RuntimeException> {

    private final Logger logger = LoggerFactory.getLogger(DummyExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException e) {
        logger.debug("Problem while executing", e);
        return Response.status(ClientResponse.Status.BAD_REQUEST)
                .type(MediaType.TEXT_PLAIN)
                .entity(e.getMessage())
                .build();
    }

}
