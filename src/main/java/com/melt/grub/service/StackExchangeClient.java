package com.melt.grub.service;

import com.melt.grub.model.SiteDto;
import com.melt.grub.model.SitesDto;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Component
public class StackExchangeClient {

    HttpClient httpClient = HttpClientBuilder.create().build();
    ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private RestTemplate restTemplate = new RestTemplate(requestFactory);

    public List<SiteDto> getSites() {
        String uri = "http://api.stackexchange.com/2.2/sites?page=1&pagesize=999&filter=!*l7am7*mGhuL-M06dtQTr_ES";

        try {
            SitesDto response = restTemplate.getForObject(new URI(uri), SitesDto.class);
            return response.getItems();

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
