package com.itrexgroup.skeleton.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface AbstractMapper<D,T> {

    D mapToDto(final T entity);

    T mapToEntity(final D dto);

    default List<D> mapAllToDto(final Collection<T> entityList){
        return entityList.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    default List<T> mapAllToEntity(final Collection<D> dtoList){
        return dtoList.stream().map(this::mapToEntity).collect(Collectors.toList());
    }
}
