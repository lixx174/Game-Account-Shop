package com.qinghaotech.infra.support;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qinghaotech.application.model.Result;
import com.qinghaotech.infra.configuration.JacksonConfiguration;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;

import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Jinx
 */
public class ManualResponseSupport {

    private static final ObjectMapper om = new JacksonConfiguration().objectMapper();

    @SneakyThrows
    public static void doJsonResponse(HttpServletResponse response, Result<?> result) {
        response.setContentType(APPLICATION_JSON_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());

        response.setStatus(
                result == null ? HttpStatus.INTERNAL_SERVER_ERROR.value() : result.getCode()
        );

        PrintWriter writer = response.getWriter();
        writer.write(om.writeValueAsString(result));
        writer.flush();
        writer.close();
    }
}
