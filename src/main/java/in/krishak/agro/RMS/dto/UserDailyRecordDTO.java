package in.krishak.agro.RMS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.sql.Timestamp;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class UserDailyRecordDTO {

    private Long userId;

    @JsonProperty("dry_bait")
    private Integer dryBait;

    @JsonProperty("green_bait")
    private Integer greenBait;

    private Integer khal;

    private Integer churi;

    private Integer rest;

    @JsonProperty("krishak_feed")
    private Integer krishakFeed;

    private Integer milk;

    private Integer fat;

    private Integer snf;

    private Integer gobar;

    private String comment;

    @JsonProperty("created_at")
    private Timestamp createdAt;

    @JsonProperty("updated_at")
    private Timestamp updatedAt;
}
