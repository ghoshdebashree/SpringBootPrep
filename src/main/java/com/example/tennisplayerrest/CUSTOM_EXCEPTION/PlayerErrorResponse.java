package com.example.tennisplayerrest.CUSTOM_EXCEPTION;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@AllArgsConstructor
@Getter
@Setter
public class PlayerErrorResponse {
    @JsonFormat(pattern = "dd-mm-yyyy HH:MM:SS")
    private ZonedDateTime zonedDateTime;
    private int statusCode;
    private String message;
    private String path;
}
