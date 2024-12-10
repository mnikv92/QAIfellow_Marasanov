package ru.iFellow.api.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class User {
    public String name;
    public String job;
    public String id;
    public Date createdAt;
}

