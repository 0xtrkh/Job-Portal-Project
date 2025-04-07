package com.app.jp_back_end.models;

import com.app.jp_back_end.models.types.Type;

public class Job {
    private long id;
    private String title;
    private String description;
    private String location;
    private Type type;
    private String category;
    private String posted_at;
    private String created_at;
    private String updated_at;
    private Company company;
    private boolean deleted;
}
