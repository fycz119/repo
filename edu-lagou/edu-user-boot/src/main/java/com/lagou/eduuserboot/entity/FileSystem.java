package com.lagou.eduuserboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @BelongsProject: edu-lagou
 * @Author: GuoAn.Sun
 * @CreateTime: 2021-03-02 17:35
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FileSystem {
    private String fileId;
    private String filePath;
    private String fileName;
}
