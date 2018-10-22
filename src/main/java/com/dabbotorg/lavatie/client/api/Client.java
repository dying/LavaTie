package com.dabbotorg.lavatie.client.api;

import com.dabbotorg.lavatie.commons.data.Identifiable;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;

@Data
@Slf4j
@Cacheable
@NoArgsConstructor
public class Client implements Identifiable {
    @Getter @Generated public long id;

    @Getter public String path;

}
