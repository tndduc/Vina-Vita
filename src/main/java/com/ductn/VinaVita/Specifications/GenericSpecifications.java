/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.Specifications;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

/**
 *
 * @author Administrator
 */
public class GenericSpecifications {

    public static <T> Specification<T> fieldEquals(String fieldName, Object value) {
        return (root, query, builder) -> builder.equal(root.get(fieldName), value);
    }

    public static <T> Specification<T> fieldContains(String fieldName, String value) {
        return (root, query, builder) -> builder.like(root.get(fieldName), "%" + value + "%");
    }

    public static <T> Specification<T> greaterThan(String fieldName, String value) {
        return (root, query, builder) -> builder.greaterThan(root.get(fieldName), value);
    }

    public static <T> Specification<T> lessThan(String fieldName, String value) {
        return (root, query, builder) -> builder.lessThan(root.get(fieldName), value);
    }

    public static <T> Specification<T> greaterThanOrEqualTo(String fieldName, String value) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(fieldName), value);
    }

    public static <T> Specification<T> lessThanOrEqualTo(String fieldName, String value) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(fieldName), value);
    }

    public static <T> Specification<T> greaterThanOrEqualToDate(String fieldName, Date value) {
        return (root, query, builder) -> builder.greaterThanOrEqualTo(root.get(fieldName), value);
    }

    public static <T> Specification<T> lessThanOrEqualToDate(String fieldName, Date value) {
        return (root, query, builder) -> builder.lessThanOrEqualTo(root.get(fieldName), value);
    }

    public static <T> Specification<T> orderByAscending(String fieldName) {
        return (root, query, builder) -> {
            query.orderBy(builder.asc(root.get(fieldName)));
            return builder.conjunction();
        };
    }

    public static <T> Specification<T> orderByDescending(String fieldName) {
        return (root, query, builder) -> {
            query.orderBy(builder.desc(root.get(fieldName)));
            return builder.conjunction();
        };
    }

    public static <T> Specification<T> createSpecification(List<Specification<T>> Specifications) {
        Specification<T> combinedSpec = null;

        if (!Specifications.isEmpty()) {
            for (Specification<T> spec : Specifications) {
                if (combinedSpec == null) {
                    combinedSpec = Specification.where(spec);
                } else {
                    combinedSpec = combinedSpec.and(spec);
                }
            }
        }
        return combinedSpec;
    }
}
