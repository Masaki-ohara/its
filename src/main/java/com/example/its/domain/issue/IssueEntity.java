package com.example.its.domain.issue;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class IssueEntity {
    private long id;
    private String summary;
    private String description;

//    public IssueEntity(long id, String summary, String description) {
//        this.id = id;
//        this.summary = summary;
//        this.description = description;
//    }
//ß
}