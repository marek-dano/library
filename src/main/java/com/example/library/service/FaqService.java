package com.example.library.service;

import lombok.RequiredArgsConstructor;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.FaqApi;
import org.openapitools.client.model.Faq;
import org.openapitools.client.model.NewFaq;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqService {
    private final FaqApi faqApi;

    public Faq getFaq(Long id) throws ApiException {
        return faqApi.findFaqById(id);
    }

    public Faq addFaq(NewFaq faq) throws ApiException {
        return faqApi.addFaq(faq);
    }

    public void deleteFaq(Long id) throws ApiException {
        faqApi.deleteFaq(id);
    }
}
