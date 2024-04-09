package com.example.its.web.issue;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
@Data
public class IssueForm {

    @NotBlank //入力必須バリデーション
    @Size(max=256) //文字数のバリデーション
    private String summary;
    @NotBlank //入力必須バリデーション
    @Size(max=256) //文字数のバリデーション
    private String description;
}
