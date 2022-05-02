package io.tavet.aid.domain.entity.location;

import java.util.regex.Pattern;

import static io.tavet.aid.domain.util.Regex.LATITUDE_REGEX;
import static io.tavet.aid.domain.util.Regex.LONGITUDE_REGEX;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeoLocation implements Location {
    private String latitude;
    private String longitude;

    @Override
    public boolean isValid() {
        return Pattern.matches(LATITUDE_REGEX, latitude) && Pattern.matches(LONGITUDE_REGEX, longitude);
    }
}
