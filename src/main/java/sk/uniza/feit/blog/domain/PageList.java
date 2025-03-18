package sk.uniza.feit.blog.domain;

import java.util.Collection;

public record PageList<T>(
        Collection<T> content,

        long totalCount,

        Object summaryRow
) {
}

