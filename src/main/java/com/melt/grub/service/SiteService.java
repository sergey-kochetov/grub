package com.melt.grub.service;

import com.google.common.collect.ImmutableList;
import com.melt.grub.model.Site;
import com.melt.grub.model.SiteDto;
import com.melt.grub.repo.SiteRepo;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

@Service
public class SiteService {

    @Autowired
    private SiteRepo siteRepo;

    @Autowired
    private StackExchangeClient stackExchangeClient;

    public List<Site> findAll() {
        return stackExchangeClient.getSites()
                .stream()
                .map(this::toSite)
                .filter(this::ignoreMeta)
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
    }

    private boolean ignoreMeta(@NonNull Site site) {
        return !site.getId().contains("meta.");
    }

    private Site toSite(@NonNull SiteDto input) {
        return new Site(
                getNameId(input),
                input.getSite_url(),
                input.getFavicon_url(),
                input.getName(),
                input.getAudience());
    }

    private String getNameId(@NonNull SiteDto input) {
        return input.getSite_url()
                .substring("https://".length(),
                        input.getSite_url().length() - ".com".length());
    }

//    public List<Site> findAll() {
//        return siteRepo.findAll();
//    }
}
