package com.concrete.challenge.bean.categories.external;

import com.concrete.challenge.bean.categories.structure.AbstractCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SubCategoryLevel4 extends AbstractCategory {

    @Builder
    public SubCategoryLevel4(String id, String name, int relevance) {
        super(id, name, relevance);
    }
}
