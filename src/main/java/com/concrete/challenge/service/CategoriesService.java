package com.concrete.challenge.service;

import com.concrete.challenge.bean.categories.external.SubCategoryLevel2;
import com.concrete.challenge.bean.categories.structure.Category;
import com.concrete.challenge.client.CategoriesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesClient categoriesClient;

    public List<Category> getTopCategories(int relevantCategories) {
        return categoriesClient.getCategory()
                .getSubcategories()
                .stream()
                .flatMap(x -> x.getSubcategories().stream())
                .sorted(Comparator.comparing(SubCategoryLevel2::getRelevance))
                .limit(relevantCategories)
                .collect(Collectors.toList());
    }

    public List<Category> getTopCategoriesAfterTop(int relevantCategories) {
        return categoriesClient.getCategory()
                .getSubcategories()
                .stream()
                .flatMap(x -> x.getSubcategories().stream())
                .sorted(Comparator.comparing(SubCategoryLevel2::getRelevance))
                .skip(relevantCategories)
                .collect(Collectors.toList());
    }
}
