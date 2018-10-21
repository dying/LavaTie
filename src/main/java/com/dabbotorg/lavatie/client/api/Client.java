package com.dabbotorg.lavatie.client.api;

import com.dabbotorg.lavatie.commons.data.Identifiable;
import lombok.*;
import org.springframework.cache.annotation.Cacheable;

@Data
@Cacheable
@NoArgsConstructor
public class Client implements Identifiable {
    @Getter @Generated public long id;

    @Getter public String path;

}
