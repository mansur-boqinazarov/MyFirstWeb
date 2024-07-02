package uz.pdp.web2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class File {
    private int id;
    private String original_name;
    private String mime_type;
    private String new_name;
    private byte[] file;
    private LocalDateTime uploadTime;
}
