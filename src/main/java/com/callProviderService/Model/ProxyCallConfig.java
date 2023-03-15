package com.callProviderService.Model;

import enums.Provider;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class ProxyCallConfig {
    private Provider provider;
}
